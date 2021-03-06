package UserService;

import java.util.List;

import com.utils.TransferArray;

import Entity.Btn;
import Entity.MenudtreeData;
import Entity.layui;
import Entity.menu;
import Entity.product;
import Entity.role;
import Entity.user;
import UserDao.UserDaoImpl;
import UserDao.UserDaos;

public class UserServlceImpl implements UserServices {
	private UserDaos ud = new UserDaoImpl();

	@Override
	public user Login(String loginname, String password) {
		// TODO Auto-generated method stub
		return ud.Login(loginname, password);
	}

	@Override
	public List<menu> guan(int id) {
		// TODO Auto-generated method stub
		return ud.guan(id);
	}

	@Override
	public List<menu> fuid(int id) {
		// TODO Auto-generated method stub
		return ud.fuid(id);
	}

	@Override
	public layui<user> userseleall() {
		List<user> list = ud.userseleall();
		int count = ud.usercount();
		layui<user> page = new layui<user>();
		page.setCode(0);
		page.setMsg("");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int usercount() {
		// TODO Auto-generated method stub
		return ud.usercount();
	}

	@Override
	public layui<menu> menuseleall() {
		List<menu> list = ud.menuseleall();
		int count = ud.usercount();
		layui<menu> page = new layui<menu>();
		page.setCode(0);
		page.setMsg("");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int menucount() {
		// TODO Auto-generated method stub
		return ud.menucount();
	}

	@Override
	public layui<user> roleseleall() {
		List<user> list = ud.roleseleall();
		int count = ud.usercount();
		layui<user> page = new layui<user>();
		page.setCode(0);
		page.setMsg("");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int rolecount() {
		// TODO Auto-generated method stub
		return ud.rolecount();
	}

	@Override
	public int deleted(int id) {
		int num = this.ud.deleted(id);
		if (num > 1) {
			return 0;
		}
		return 1;
	}

	@Override
	public boolean insertd(user ys) {
		int num = this.ud.insertd(ys);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updated(user ys) {
		int num = this.ud.updated(ys);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public user updateid(int id) {
		return ud.updateid(id);
	}

	@Override
	public layui<MenudtreeData> allMenu() {
		return ud.allMenu();
	}

	@Override
	public List<menu> allMenuid(int id) {
		return ud.allMenu(id);
	}

	@Override
	public int fenpei(int id, String[] num) {
		int row = ud.deleteqx(id); // ??????????id??????????
		System.out.println(row+"ss");
		int[] arrs = TransferArray.StringToInt(num);
		int count = 0;
		if (row != -1) {
			for (int i = 0; i < arrs.length; i++) {
				int yes = ud.insertqx(id, arrs[i]); // ????????????
				if (yes > 0) {
					count++;// ????????????++ ??????????????????
				}
			}
		}
		return count;
	}

	@Override
	public List<Btn> selectBtn() {
		// TODO Auto-generated method stub
		return ud.selectBtn();
	}

	@Override
	public boolean insertQx(menu ys) {
		int num = this.ud.insertQx(ys);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<menu> seqxList(int type) {
		// TODO Auto-generated method stub
		return ud.seqxList(type);
	}

	@Override
	public layui<product> productseleall() {
		List<product> list = ud.productseleall();
		int count = ud.usercount();
		layui<product> page = new layui<product>();
		page.setCode(0);
		page.setMsg("");
		page.setCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int productcount() {
		// TODO Auto-generated method stub
		return ud.productcount();
	}

	@Override
	public boolean upchanpins(product ys) {
		int num = this.ud.upchanpin(ys);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public product upprods(int id) {
		return ud.upprod(id);
	}

	@Override
	public boolean inschanpins(product ys) {
		int num = this.ud.inschanpin(ys);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int deletpt(int id) {
		int num = this.ud.deletpt(id);
		if (num > 1) {
			return 0;
		}
		return 1;
	}

}
