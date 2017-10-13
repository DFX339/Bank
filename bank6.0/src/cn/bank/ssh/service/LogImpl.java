package cn.bank.ssh.service;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;

import cn.bank.ssh.bean.Log;

@Controller
public class LogImpl implements LogService {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	//�����־�ķ���
	public void addLog(Log log) {
		hibernateTemplate.save(log);
	}

}
