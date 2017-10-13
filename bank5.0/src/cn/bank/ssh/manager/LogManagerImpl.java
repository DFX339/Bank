package cn.bank.ssh.manager;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bank.ssh.bean.Log;
/**
 * ����5.0��־ʵ���࣬ͨ��hibernate��Ϊ�־ò㣬�̳�HibernateDaoSupport
 * ֱ�ӵõ�HibernateTemplate(Session)��������ɾ�Ĳ����
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class LogManagerImpl extends HibernateDaoSupport implements LogManagerInterface {

	//�����־����Ӳ���
	public void addLog(Log log) {
		this.getHibernateTemplate().save(log);
	}

}
