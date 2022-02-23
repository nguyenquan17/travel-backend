-- Drop the database if it already exists
DROP DATABASE IF EXISTS Travel;
-- Create database
CREATE DATABASE IF NOT EXISTS Travel;
USE Travel;

CREATE TABLE `Tour` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL ,
	`id_regional` INT(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `TourDetail` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_tourType` INT NOT NULL,
	`id_regional` INT NOT NULL,
	`id_tour` INT NOT NULL,
    `id_user` INT NOT NULL,
	`title` varchar(255) NOT NULL,
	`description` TEXT NOT NULL,
	`schedule` varchar(255) NOT NULL,
	`day_start` DATETIME NOT NULL,
	`vehicle` varchar(255) NOT NULL,
	`departure_from` varchar(255) NOT NULL,
	`price` varchar(255) NOT NULL,
	`quantity` INT NOT NULL,
	`notes` TEXT(255) NOT NULL,
	`star` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);
CREATE TABLE `Comment` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`content` varchar(255) NOT NULL,
    `id_tourDetail` INT NOT NULL,
    `id_user` INT NOT NULL,
	PRIMARY KEY (`id`)
);
CREATE TABLE `TourType` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Regional` (
	`id` INT NOT NULL,
	`id_tourType` INT NOT NULL,
	`name_regional` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Image` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_tourDetail` INT NOT NULL,
	`image` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Invoice` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_tourOder` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `TourOrder` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_user` INT NOT NULL,
	`id_payment` INT NOT NULL,
	`id_tourDetail` INT NOT NULL,
	`name_order` varchar(255) NOT NULL,
	`date_order` DATETIME NOT NULL,
	`cost_order` varchar(255) NOT NULL,
	`number_of_people` INT NOT NULL,
	`number_of_rooms` INT NOT NULL,
    Key (id),
	PRIMARY KEY (`id_user`, `id_tourDetail`)
);

CREATE TABLE `Payment` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name_payment` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fullname` varchar(255) NOT NULL,
	`email` varchar(255) UNIQUE NOT NULL ,
	`phone` varchar(255) NOT NULL,
	`address` varchar(255) NOT NULL,
	`username` varchar(255) UNIQUE NOT NULL,
	`password` varchar(255) NOT NULL,
	`id_role` INT(255) NOT NULL,
	`active` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Role` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name_role` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User_Token` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_user` INT NOT NULL,
	`user_token` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Tour` ADD CONSTRAINT `Tour_fk0` FOREIGN KEY (`id_regional`) REFERENCES `Regional`(`id`);

ALTER TABLE `TourDetail` ADD CONSTRAINT `TourDetail_fk0` FOREIGN KEY (`id_tourType`) REFERENCES `TourType`(`id`);

ALTER TABLE `TourDetail` ADD CONSTRAINT `TourDetail_fk1` FOREIGN KEY (`id_regional`) REFERENCES `Regional`(`id`);

ALTER TABLE `TourDetail` ADD CONSTRAINT `TourDetail_fk2` FOREIGN KEY (`id_tour`) REFERENCES `Tour`(`id`);

ALTER TABLE `TourDetail` ADD CONSTRAINT `TourDetail_fk3` FOREIGN KEY (`id_user`) REFERENCES `User`(`id`);

ALTER TABLE `Regional` ADD CONSTRAINT `Regional_fk0` FOREIGN KEY (`id_tourType`) REFERENCES `TourType`(`id`);

ALTER TABLE `Image` ADD CONSTRAINT `Image_fk0` FOREIGN KEY (`id_tourDetail`) REFERENCES `TourDetail`(`id`);

ALTER TABLE `Invoice` ADD CONSTRAINT `Invoice_fk0` FOREIGN KEY (`id_tourOder`) REFERENCES `TourOrder`(`id`);

ALTER TABLE `TourOrder` ADD CONSTRAINT `TourOrder_fk0` FOREIGN KEY (`id_user`) REFERENCES `User`(`id`);

ALTER TABLE `TourOrder` ADD CONSTRAINT `TourOrder_fk1` FOREIGN KEY (`id_payment`) REFERENCES `Payment`(`id`);

ALTER TABLE `TourOrder` ADD CONSTRAINT `TourOrder_fk2` FOREIGN KEY (`id_tourDetail`) REFERENCES `TourDetail`(`id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`id_role`) REFERENCES `Role`(`id`);

ALTER TABLE `User_Token` ADD CONSTRAINT `User_Token_fk0` FOREIGN KEY (`id_user`) REFERENCES `User`(`id`);

ALTER TABLE `Comment` ADD CONSTRAINT `Comment_fk0` FOREIGN KEY (`id_tourDetail`) REFERENCES `TourDetail`(`id`);

ALTER TABLE `Comment` ADD CONSTRAINT `Comment_fk1` FOREIGN KEY (`id_user`) REFERENCES `User`(`id`);






INSERT INTO `Tour` (`id`,`name`,`id_regional`)
VALUE				(1,'Tour du lich',1),
					(2,'Tour du lich1',3),
                    (3,'Tour du lich2',2),
                    (4,'Tour du lich22',4);

INSERT INTO `TourDetail` (`id`,`id_tourType`,`id_regional`,`id_tour`,`id_user`,`title`,`description`,`schedule`,`day_start`,`vehicle`,`departure_from`,`price`,`quantity`,`notes`,`star`)
VALUE					(1		,1				,1			,1		,1		,'Du lịch Miền Bắc Hà Nội -Đền Hùng từ Sài Gòn','Tour Tây Bắc Nổi tiếng với nhiều địa điểm tham quan, 
vui chơi mang đậm bản sắc văn hóa dân tộc, thiên nhiên hùng vĩ, thơ mộng. Tất cả khung cảnh nơi
 núi rừng này dường như đều được thiên nhiên “sắp đặt” một cách rất tài tình,
 sẵn sàng làm xao xuyến tâm hồn của bất cứ ai đặt chân đến dây. Bạn đã dự định sẽ du lịch Tây 
 Bắc một lần để tự mình cảm nhận những nét đẹp của nơi đây xem có đúng như lời quảng bá hay không? Hãy nhanh tay đặt tour du lịch Hè tại Du Lịch Việt đi và cảm nhận nhé!',
 '6 ngày 5 đêm','2020-09-14','Máy bay','Hà Nội','20.000.000',4,'Sau khi đăng ký, thanh toán ít nhất 50% tiền cọc và đóng hết 100% trước  khởi hành 10 ngày','Xuất sắc');


INSERT INTO `Tourtype` (`id`,`name`)
VALUE					(1,'Du lịch trong nước'),
						(2,'Du lịch ngoài nước'),
                        (3,'Du lịch Biển đảo'),
                        (4,'Du lịch rừng');
                        
INSERT INTO `Regional` (`id`,`id_tourType`,`name_regional`)
VALUE					(1,1,'Du lịch Miền bắc'),
						(2,1,'Du lịch Tây bắc'),
                        (3,1,'Du lịch Miền Nam'),
                        (4,1,'Du lịch Miền Trung');

INSERT INTO `User` 	(`fullname`,			`email`,						`phone`,														`address`,		`username`, 	`password` ,	`id_role`,`active`	)
VALUE				('Trần Danh Thái',		'hanhhanoi1999@gmail.com',		'0336827187',		'Hà Nội'	,		'Thai1234',			'1234567'	 ,	1,true ),
					('Trần Danh Thái1',		'hanhhanoi19@gmail.com',		'0233443187',		'Sài Gòn'	,		'th3i23232',			'1234567'	 ,	2,false );

INSERT INTO `Role` (`name_role`)
VALUE				('Admin'),
					('User'),
                   ('Manager');












