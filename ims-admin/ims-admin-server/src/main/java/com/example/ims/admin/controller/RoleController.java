/*
 *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ims.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ims.admin.api.entity.SysRole;
import com.example.ims.admin.service.SysRoleMenuService;
import com.example.ims.admin.service.SysRoleService;
import com.example.ims.common.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
	private final SysRoleService sysRoleService;
	private final SysRoleMenuService sysRoleMenuService;

	/**
	 * 通过ID查询角色信息
	 *
	 * @param id ID
	 * @return 角色信息
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return R.ok(sysRoleService.getById(id));
	}

	/**
	 * 添加角色
	 *
	 * @param sysRole 角色信息
	 * @return success、false
	 */
	@SysLog("添加角色")
	@PostMapping
	public R save(@Valid @RequestBody SysRole sysRole) {
		return R.ok(sysRoleService.save(sysRole));
	}

	/**
	 * 修改角色
	 *
	 * @param sysRole 角色信息
	 * @return success/false
	 */
	@SysLog("修改角色")
	@PutMapping
	public R update(@Valid @RequestBody SysRole sysRole) {
		return R.ok(sysRoleService.updateById(sysRole));
	}

	/**
	 * 删除角色
	 *
	 * @param id
	 * @return
	 */
	@SysLog("删除角色")
	@DeleteMapping("/{id}")
	public R removeById(@PathVariable Integer id) {
		return R.ok(sysRoleService.removeRoleById(id));
	}

	/**
	 * 获取角色列表
	 *
	 * @return 角色列表
	 */
	@GetMapping("/list")
	public R listRoles() {
		return R.ok(sysRoleService.list(Wrappers.<SysRole>emptyWrapper()));
	}

	/**
	 * 分页查询角色信息
	 *
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/page")
	public R getRolePage(Page page) {
		return R.ok(sysRoleService.page(page, Wrappers.<SysRole>emptyWrapper()));
	}

	/**
	 * 更新角色菜单
	 *
	 * @param roleId  角色ID
	 * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
	 * @return success、false
	 */
	@SysLog("更新角色菜单")
	@PutMapping("/menu")
	public R saveRoleMenus(Integer roleId, @RequestParam(value = "menuIds", required = false) String menuIds) {
		SysRole sysRole = sysRoleService.getById(roleId);
		return R.ok(sysRoleMenuService.saveRoleMenus(sysRole.getRoleCode(), roleId, menuIds));
	}
}
