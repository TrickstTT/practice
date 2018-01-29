1.搭建环境
2.导包

3.搭建目录结构
	
4.创建数据库
	CREATE DATABASE season02_test;
	USE season02_test;
	CREATE TABLE USER(
		id INT PRIMARY KEY AUTO_INCREMENT,
		userName VARCHAR(20),
		NAME VARCHAR(20),
		gender VARCHAR(4),
		PASSWORD VARCHAR(20),
		idCard VARCHAR(20),
		phone VARCHAR(20),
		qq VARCHAR(20),
		number VARCHAR(20),
		school VARCHAR(20),
		studyStatus VARCHAR(20),
		background VARCHAR(20),
		class VARCHAR(20),
		applyDate VARCHAR(20),
		addr VARCHAR(20)
	);
	CREATE TABLE img(
		userName VARCHAR(20),
		touXiangImg VARCHAR(200) DEFAULT'img/default/touxiangImg.jpg',
		idFontImg VARCHAR(200) DEFAULT'img/default/zhengJianImg.jpg',
		idBackImg VARCHAR(200) DEFAULT'img/default/zhengJianImg.jpg',
		biYeZhengImg VARCHAR(200) DEFAULT'img/default/zhengJianImg.jpg'
	)