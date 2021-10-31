INSERT INTO `tb_permission` (`id`, `parent_id`, `name`, `enname`, `url`, `description`)
VALUES
	(1,0,'用户管理','UserManage','/users/',NULL),
	(2,1,'查看用户','UserView','',NULL),
	(3,1,'新增用户','UserAdd','',NULL);

INSERT INTO `tb_role` (`id`, `parent_id`, `name`, `enname`, `description`)
VALUES
	(1,0,'超级管理员','admin',NULL);

INSERT INTO `tb_role_permission` (`id`, `role_id`, `permission_id`)
VALUES
	(1,1,1),
	(2,1,2),
	(3,1,3);

INSERT INTO `tb_user` (`id`, `username`, `password`, `phone`)
VALUES
	(1,'admin','$2a$10$v1lmNhByOnftpJuG7G8zRO5JQGz5czsgX1GGnrAzNYHjzCHp1xO2a','12388886666');

INSERT INTO `tb_user_role` (`id`, `user_id`, `role_id`)
VALUES
	(1,1,1);