DROP TABLE IF EXISTS BUG_TRACK;

CREATE TABLE BUG_TRACK(
                          ID             CHAR(36) not null,
                          FIRST_NAME     VARCHAR(250),
                          LAST_NAME      VARCHAR(250),
                          EMAIL          VARCHAR(50),
                          RECORDING_DATE DATE,
                          DESCRIPTION    NCLOB,
                          STATUS         NUMBER(1),

                          primary key (ID)
);
