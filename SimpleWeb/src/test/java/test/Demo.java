package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月14日 @decript:
 */
public class Demo {
	static List<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		while(true){
			System.out.println("请选择你要的操作：");
		System.out.println("菜单 ： A 注册  B 登陆 C 退出 ");
		// Scanner 的对象 sc是用来获取键盘输入值 
		Scanner sc = new Scanner(System.in);
		// sc.nextLine(); 获取输入的字符串
		String flag = sc.nextLine();
		// equalsIgnoreCase 和 equals的区别是 这个忽略大小写 进行比较
		if ("a".equalsIgnoreCase(flag)) {
			User user = new User();
			System.out.println("请输入注册的姓名：");
			while (true) {
				// 给创建的user赋值name
				user.setName(sc.nextLine());
				// 这里调用自己写的isAble方法 来判断 这个对象是否已经注册过了(即在list里面有相同name的对象)
				if (isAble(user)) {
					System.out.println("该用户已注册,请重新输入");
				} else {
					break;
				}
			}
			System.out.println("请输入注册的密码：");
			user.setPassword(sc.nextLine());
			// 向用户集合添加用户
			userList.add(user);
			System.out.println("注册成功");
		} else if ("b".equalsIgnoreCase(flag)) {
			    boolean success=false;
				System.out.println("请输入你的姓名：");
				String name=sc.nextLine();
				System.out.println("输入的姓名："+name);
				System.out.println("请输入你的密码：");
				String password = sc.nextLine();
				System.out.println("输入的密码："+password);
				// it是迭代器  所有集合类都有迭代器
				Iterator<User> it=userList.iterator();
				// it.hasNext() 意思是如果it里面有元素 就返回true
				while(it.hasNext()){
					// it.next()是拿到 当前这个值 并把指针移动指向下一个(再次调用next()会取到下一个值)
					User tempU=it.next();
					System.out.println("当前对象的姓名："+tempU.getName().equals(name));
					System.out.println("当前对象的密码："+tempU.getPassword().equals(password));
					if(tempU.getName().equals(name)&&tempU.getPassword().equals(password))
						success=true;
				}
				if(success){
					System.out.println("登陆成功");
				}else{
					System.out.println("用户名或密码错误");
				}
		}else{
			System.exit(0);
		}
		}
	}

	public static boolean isAble(User o) {
		Iterator<User> it=userList.iterator();
		while(it.hasNext()){
			it.next().getName().equals(o.getName());
				return true;
			}
		return false;
	}
}
