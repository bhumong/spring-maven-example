CREATE TABLE IF NOT EXISTS `users` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `created_at` BIGINT,
  `updated_at` BIGINT,
  `deleted_at` BIGINT,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `UNIQUE` (`email`)
);