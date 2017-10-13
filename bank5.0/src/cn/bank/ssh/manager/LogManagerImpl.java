package cn.bank.ssh.manager;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bank.ssh.bean.Log;
/**
 * 银行5.0日志实现类，通过hibernate作为持久层，继承HibernateDaoSupport
 * 直接得到HibernateTemplate(Session)，进行增删改查操作
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class LogManagerImpl extends HibernateDaoSupport implements LogManagerInterface {

	//完成日志的添加操作
	public void addLog(Log log) {
		this.getHibernateTemplate().save(log);
	}

}
