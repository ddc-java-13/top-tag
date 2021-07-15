CREATE TABLE IF NOT EXISTS `game_management_unit`
(
    `game_management_unit_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `unit_number`             INTEGER                           NOT NULL,
    `animal_name`             TEXT,
    `herd_size`               INTEGER                           NOT NULL,
    `harvest_number`          INTEGER                           NOT NULL,
    `tag_applications`        INTEGER                           NOT NULL,
    `tags_issued`             INTEGER                           NOT NULL
);

CREATE INDEX IF NOT EXISTS `index_game_management_unit_unit_number` ON `game_management_unit` (`unit_number`);

CREATE TABLE IF NOT EXISTS `application_choice`
(
    `application_choice_id`   INTEGER NOT NULL,
    `game_management_unit_id` INTEGER NOT NULL,
    `season`                  TEXT,
    `user_id`                 INTEGER NOT NULL,
    `weapon_type`             INTEGER,
    PRIMARY KEY (`application_choice_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`game_management_unit_id`) REFERENCES `game_management_unit` (`game_management_unit_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_application_choice_game_management_unit_id` ON `application_choice` (`game_management_unit_id`);

CREATE INDEX IF NOT EXISTS `index_application_choice_season` ON `application_choice` (`season`);

CREATE INDEX IF NOT EXISTS `index_application_choice_user_id` ON `application_choice` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_application_choice_weapon_type` ON `application_choice` (`weapon_type`);

CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_name` TEXT                              NOT NULL,
    `oauth_key` TEXT
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_User_user_name` ON `user` (`user_name`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON `user` (`oauth_key`);

