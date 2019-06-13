CREATE TABLE `tabelogdb`.`restaurant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NOT NULL,
  `url` VARCHAR(90) NOT NULL,
  `station` VARCHAR(45) NOT NULL,
  `score` DOUBLE NULL,
  `reviews` INT NULL,
  PRIMARY KEY (`id`));
