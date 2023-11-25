# <ENGLISH: MASTER TABLE / SPANISH: TABLA MAESTRA>
# <ENGLISH: PERSON / SPANISH: PERSONAS>
CREATE TABLE IF NOT EXISTS `MSS_`.`0_Prsn` (
    `Rfrnc`         INT(255) NOT NULL AUTO_INCREMENT COMMENT 'Rfrnc         (English: Reference                                                                      / Spanish: Referencia)',
    `Rfrnc_Prsn`    INT(255) NOT NULL                COMMENT 'Rfrnc_Prsn    (English: Reference. Person [Natural Persons (0_NtrlPrsns) U Legal Persons (0_LglPrsns)] / Spanish: Referencia. Persona [Personas Naturales (0_NtrlPrsns) U Personas Jurídicas (0_LglPrsns)])',
    `Rfrnc_TypPrsn` INT(2)   NOT NULL                COMMENT 'Rfrnc_TypPrsn (English: Reference. Type of Person                                                      / Spanish: Referencia. Tipo de Persona)',    
    `Cndtn`         INT(2)   NOT NULL                COMMENT 'Cndtn         (English: Condition [0: Inactive, 1: Active]                                             / Spanish: Estado              [0: Inactivo, 1: Activo])',
    `Rmvd`          INT(2)   NOT NULL                COMMENT 'Rmvd          (English: Removed [0: Inactive, 1: Active]                                               / Spanish: Eliminado           [0: Inactivo, 1: Activo])',
    `Lckd`          INT(2)   NOT NULL                COMMENT 'Lckd          (English: Locked [0: Inactive, 1: Active]                                                / Spanish: Bloqueado           [0: Inactivo, 1: Activo])',
    `DtAdmssn`      DATE         NULL                COMMENT 'DtAdmssn      (English: Date of Admission                                                              / Spanish: Fecha de Ingreso)',
    `ChckTm`        TIME         NULL                COMMENT 'ChckTm        (English: Check In Time                                                                  / Spanish: Hora de Ingreso)', 
    PRIMARY KEY (`Rfrnc`)
) ENGINE='InnoDB' DEFAULT CHARSET='utf8' COLLATE='utf8_bin' COMMENT='0_Prsn (English: 0 - Person / Spanish: 0 - Personas)';
# <.ENGLISH: PERSON / SPANISH: PERSONAS>
# <.ENGLISH: MASTER TABLE / SPANISH: TABLA MAESTRA>

# <ENGLISH: MASTER TABLE / SPANISH: TABLA MAESTRA>
# <ENGLISH: TYPES OF PERSON/ SPANISH: TIPOS DE PERSONAS>
CREATE TABLE IF NOT EXISTS `MSS_`.`0_TypsPrsns` (
    `Rfrnc`           INT    (255) NOT NULL AUTO_INCREMENT COMMENT 'Rfrnc           (English: Reference                          / Spanish: Referencia)',
    `Nm`              VARCHAR(255) NOT NULL                COMMENT 'Nm              (English: Name                               / Spanish: Nombre)',
    `Dscrptn`         VARCHAR(60)  NOT NULL                COMMENT 'Dscrptn         (English: Description                        / Spanish: Descripción)',
    `Rfrnc_TypsPrsns` INT    (255)     NULL                COMMENT 'Rfrnc_TtpsPrsns (English: Reference. Types of Person         / Spanish: Referencia. Tipos de Personas)',   
    `Cndtn`           INT    (2)   NOT NULL                COMMENT 'Cndtn           (English: Condition [0: Inactive, 1: Active] / Spanish: Estado              [0: Inactivo, 1: Activo])',
    `Rmvd`            INT    (2)   NOT NULL                COMMENT 'Rmvd            (English: Removed   [0: Inactive, 1: Active] / Spanish: Eliminado           [0: Inactivo, 1: Activo])',
    `Lckd`            INT    (2)   NOT NULL                COMMENT 'Lckd            (English: Locked    [0: Inactive, 1: Active] / Spanish: Bloqueado           [0: Inactivo, 1: Activo])',
    `DtAdmssn`        DATE             NULL                COMMENT 'DtAdmssn        (English: Date of Admission                  / Spanish: Fecha de Ingreso)',
    `ChckTm`          TIME             NULL                COMMENT 'ChckTm          (English: Check In Time                      / Spanish: Hora de Ingreso)', 
    PRIMARY KEY (`Rfrnc`)
) ENGINE='InnoDB' DEFAULT CHARSET='utf8' COLLATE='utf8_bin' COMMENT='0_TypsPrsns (English: 0 - Types of Person/ Spanish: 0 - Tipos de Personas)';
# <.ENGLISH: TYPES OF PERSON/ SPANISH: TIPOS DE PERSONAS>
# <.ENGLISH: MASTER TABLE / SPANISH: TABLA MAESTRA>

# <ENGLISH: NATURAL PERSON / SPANISH: PERSONAS NATURALES>
CREATE TABLE IF NOT EXISTS `MSS_`.`0_NtrlPrsn` (
    `Rfrnc`         INT    (255) NOT NULL AUTO_INCREMENT COMMENT 'Rfrnc         (English: Reference                          / Spanish: Referencia)',
    `Rfrnc_Ncnlty`  INT    (255)     NULL                COMMENT 'Rfrnc_Ncnlty  (English: Reference. Nacionality             / Spanish: Referencia. Nacionalidad)',
    `Rfrnc_Cntry`   INT    (255)     NULL                COMMENT 'Rfrnc_Cntry   (English: Reference. Country                 / Spanish: Referencia. Pais)',
    `IdntfctnDcmnt` VARCHAR(45)  NOT NULL                COMMENT 'IdntfctnDcmnt (English: Identification Document            / Spanish: Documento de Idetentidad)',
    `Nms`           VARCHAR(35)  NOT NULL                COMMENT 'Nms           (English: Names                              / Spanish: Nombres)',
    `Srnms`         VARCHAR(35)  NOT NULL                COMMENT 'Srnms         (English: Surnames                           / Spanish: Apellidos)',
    `RfrntlPhnNmbr` VARCHAR(20)      NULL                COMMENT 'RfrntlPhnNmbr (English: Referential Phone Number           / Spanish: Número de Teléfono Referencial)',
    `TxAddrss`      TEXT         NOT NULL                COMMENT 'TxAddrss      (English: Tax Address                        / Spanish: Domicilio Fiscal)',
    `Cndtn`         INT    (2)   NOT NULL                COMMENT 'Cndtn         (English: Condition [0: Inactive, 1: Active] / Spanish: Estado    [0: Inactivo, 1: Activo])',
    `Rmvd`          INT    (2)   NOT NULL                COMMENT 'Rmvd          (English: Removed   [0: Inactive, 1: Active] / Spanish: Eliminado [0: Inactivo, 1: Activo])',
    `Lckd`          INT    (2)   NOT NULL                COMMENT 'Lckd          (English: Locked    [0: Inactive, 1: Active] / Spanish: Bloqueado [0: Inactivo, 1: Activo])',
    `DtAdmssn`      DATE             NULL                COMMENT 'DtAdmssn      (English: Date of Admission                  / Spanish: Fecha de Ingreso)',
    `ChckTm`        TIME             NULL                COMMENT 'ChckTm        (English: Check In Time                      / Spanish: Hora de Ingreso)', 
    PRIMARY KEY (`Rfrnc`)
) ENGINE='InnoDB' DEFAULT CHARSET='utf8' COLLATE='utf8_bin' COMMENT='0_NtrlPrsn (English: 0 - Natural Person / Spanish: 0 - Personas Naturales)';
# <.ENGLISH: NATURAL PERSON / SPANISH: PERSONAS NATURALES>