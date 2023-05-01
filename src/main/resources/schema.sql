CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    desc text,
    status varchar(20) NOT NULL,
    content_type varchar(50) NOT NULL,
    data_created TimeStamp NOT NULL,
    data_updated TimeStamp,
    url varchar(255),
    primary key(id)
);

INSERT INTO Content(title, desc, status, content_type, data_created) VALUES ('TITLE', 'DESC', 'IDEA',
                             'ARTICLE', CURRENT_TIMESTAMP());