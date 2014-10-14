/*
SQLyog Ultimate v9.51 
MySQL - 5.6.19 : Database - pizzaria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pizzaria` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pizzaria`;

/*Table structure for table `caixa_saldo_dia` */

DROP TABLE IF EXISTS `caixa_saldo_dia`;

CREATE TABLE `caixa_saldo_dia` (
  `cxs_dt_movto` date NOT NULL,
  `cxs_stt_aber_fech` char(1) NOT NULL COMMENT 'A=Aberto  F=Fechado',
  `cxs_sdo_inicial_dinh` decimal(10,2) NOT NULL,
  `cxs_sdo_inicial_cheq` decimal(10,2) NOT NULL,
  PRIMARY KEY (`cxs_dt_movto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cargo` */

DROP TABLE IF EXISTS `cargo`;

CREATE TABLE `cargo` (
  `crg_id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `crg_descr` varchar(20) NOT NULL,
  PRIMARY KEY (`crg_id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cargos da Empresa';

/*Table structure for table `cep` */

DROP TABLE IF EXISTS `cep`;

CREATE TABLE `cep` (
  `cep_cod` char(8) NOT NULL,
  `cep_ender` varchar(100) DEFAULT NULL,
  `cep_bai` varchar(100) DEFAULT NULL,
  `cep_cid` varchar(30) DEFAULT NULL,
  `cep_municip` int(11) NOT NULL,
  PRIMARY KEY (`cep_cod`),
  KEY `cep_municip_idx` (`cep_municip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de CEP e Endereços';

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `cli_cod` int(11) NOT NULL AUTO_INCREMENT,
  `cli_nome` varchar(50) NOT NULL,
  `cli_cep` char(8) NOT NULL,
  `cli_nro_ender` int(11) NOT NULL,
  `cli_email` varchar(45) DEFAULT NULL,
  `cli_telefone` varchar(45) NOT NULL,
  `cli_tel_cel` varchar(45) DEFAULT NULL,
  `cli_aniversario` date DEFAULT NULL,
  `cli_datacad` date DEFAULT NULL,
  `cli_dt_ult_compra` date DEFAULT NULL COMMENT 'data da ultima compra feita pelo cliente\\\\n',
  `cli_stt_inadimp` char(1) DEFAULT 'N',
  `cli_rua` varchar(50) DEFAULT NULL,
  `cli_bairro` varchar(50) DEFAULT NULL,
  `cli_obs` varchar(100) DEFAULT NULL,
  `cli_cidade` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cli_cod`),
  KEY `fk_cliente_cep_idx` (`cli_cep`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastro dos Clientes';

/*Table structure for table `cupom` */

DROP TABLE IF EXISTS `cupom`;

CREATE TABLE `cupom` (
  `cup_cod_id` int(11) NOT NULL AUTO_INCREMENT,
  `cup_vlr` decimal(8,2) NOT NULL,
  `cup_tributos` decimal(7,2) DEFAULT NULL,
  `cup_dt_emissao` date NOT NULL,
  `cup_hr_emissao` time NOT NULL,
  `cup_ped_cod` int(11) NOT NULL,
  PRIMARY KEY (`cup_cod_id`),
  KEY `fk_cupom_pedido_idx` (`cup_ped_cod`),
  CONSTRAINT `fk_cupom_pedido` FOREIGN KEY (`cup_ped_cod`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cupom_item` */

DROP TABLE IF EXISTS `cupom_item`;

CREATE TABLE `cupom_item` (
  `cupi_cod_cup` int(11) NOT NULL,
  `cupi_cod` int(11) NOT NULL AUTO_INCREMENT,
  `cupi_cod_prod` int(11) NOT NULL,
  `cupi_qtd` int(11) NOT NULL,
  `cupi_vlr_unit` decimal(6,2) NOT NULL,
  `cupi_vlr_tot` decimal(8,2) NOT NULL,
  `cupi_vlr_desc` decimal(7,2) DEFAULT NULL,
  `cupi_vlr_tributo` decimal(7,2) DEFAULT NULL,
  `cupi_cod_prod2` int(11) DEFAULT NULL,
  PRIMARY KEY (`cupi_cod_cup`,`cupi_cod`),
  KEY `fk_cupom_item_produto_idx` (`cupi_cod_prod`),
  KEY `fk_cupom_item_cupom_idx` (`cupi_cod_cup`),
  KEY `cupi_cod` (`cupi_cod`),
  CONSTRAINT `fk_cupom_item_cupom` FOREIGN KEY (`cupi_cod_cup`) REFERENCES `cupom` (`cup_cod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cupom_item_produto` FOREIGN KEY (`cupi_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cupom_titulos_receb` */

DROP TABLE IF EXISTS `cupom_titulos_receb`;

CREATE TABLE `cupom_titulos_receb` (
  `ctrc_cupom` int(10) unsigned NOT NULL,
  `ctrc_ser` char(3) NOT NULL,
  `ctrc_seq` int(10) unsigned NOT NULL,
  `ctrc_num_tit_receb` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ctrc_cupom`,`ctrc_ser`,`ctrc_seq`,`ctrc_num_tit_receb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `emp_id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `emp_cod_pfj` decimal(15,0) NOT NULL,
  `emp_fis_jur_emp` char(1) NOT NULL DEFAULT 'J' COMMENT 'Identifica se o cod_pfj � pessoa F-Fisica ou J-Juridica',
  `emp_cep` decimal(8,0) NOT NULL,
  `emp_raz_emp` varchar(45) NOT NULL,
  `emp_fantasia_emp` varchar(20) NOT NULL COMMENT 'nome fantasia da emprea',
  `emp_nro_ender` int(11) NOT NULL,
  `emp_inscr_est` varchar(20) DEFAULT NULL COMMENT 'inscricao estadual da empresa',
  `emp_tel1` varchar(15) DEFAULT NULL,
  `emp_tel2` varchar(15) DEFAULT NULL,
  `emp_tel_cel` varchar(15) DEFAULT NULL,
  `emp_tel_cel2` varchar(15) DEFAULT NULL,
  `emp_email` varchar(45) DEFAULT NULL,
  `emp_site` varchar(45) DEFAULT NULL,
  `emp_dt_movto` date DEFAULT NULL,
  PRIMARY KEY (`emp_id_empresa`),
  KEY `fk_empresa_cep_idx` (`emp_cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela com dados da  Empresa';

/*Table structure for table `fech_estoq_mes` */

DROP TABLE IF EXISTS `fech_estoq_mes`;

CREATE TABLE `fech_estoq_mes` (
  `fec_ano_mes_fech` int(10) unsigned NOT NULL,
  `fec_cod_prod` int(10) unsigned NOT NULL,
  `fec_qtde_sdo_inicial` decimal(12,5) NOT NULL,
  PRIMARY KEY (`fec_ano_mes_fech`,`fec_cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fornecedor` */

DROP TABLE IF EXISTS `fornecedor`;

CREATE TABLE `fornecedor` (
  `for_id_fornec` int(11) NOT NULL,
  `for_nome` varchar(45) DEFAULT NULL,
  `for_cod_pfj` decimal(17,0) DEFAULT NULL,
  `for_cep` char(8) DEFAULT NULL,
  `for_nro_ender` int(11) DEFAULT NULL,
  `for_email` varchar(45) DEFAULT NULL,
  `for_tel` varchar(15) DEFAULT NULL,
  `for_tel_cel` varchar(15) DEFAULT NULL,
  `for_dt_cad` date DEFAULT NULL,
  `for_contato` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`for_id_fornec`),
  KEY `fk_fornecedor_cep_idx` (`for_cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de dados dos Fornecedores';

/*Table structure for table `funcionario` */

DROP TABLE IF EXISTS `funcionario`;

CREATE TABLE `funcionario` (
  `fun_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fun_nome` varchar(50) NOT NULL,
  `fun_dt_admis` date DEFAULT NULL,
  `fun_dt_demis` date DEFAULT NULL,
  `fun_nro_ender` int(11) NOT NULL,
  `fun_cpf` varchar(14) DEFAULT NULL,
  `fun_rg` varchar(20) DEFAULT NULL,
  `fun_tel` varchar(15) DEFAULT NULL,
  `tel_cel` varchar(15) DEFAULT NULL,
  `fun_email` varchar(45) DEFAULT NULL,
  `fun_cargo` int(11) NOT NULL,
  `fun_salario` decimal(7,2) DEFAULT NULL,
  `fun_vale_transp` decimal(6,2) DEFAULT NULL,
  `fun_vale_refeicao` decimal(6,2) DEFAULT NULL,
  `fun_ctps` varchar(20) DEFAULT NULL,
  `fun_id_empresa` int(11) NOT NULL,
  `fun_permissao` char(1) DEFAULT NULL,
  `fun_nascimento` date DEFAULT NULL,
  `fun_rua` varchar(100) DEFAULT NULL,
  `fun_cep` char(8) DEFAULT NULL,
  `fun_bairro` varchar(50) DEFAULT NULL,
  `fun_cidade` varchar(50) DEFAULT NULL,
  `fun_estado` varchar(2) DEFAULT NULL,
  `fun_moto` varchar(30) DEFAULT NULL,
  `fun_cnh` varchar(30) DEFAULT NULL,
  `fun_placa_moto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`fun_codigo`),
  KEY `fk_funcionario_cargo_idx` (`fun_cargo`),
  KEY `fk_funcionario_empresa_idx` (`fun_id_empresa`),
  CONSTRAINT `fk_funcionario_cargo` FOREIGN KEY (`fun_cargo`) REFERENCES `cargo` (`crg_id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabela de Funcionarios da Empresa';

/*Table structure for table `invent_estoq_mes` */

DROP TABLE IF EXISTS `invent_estoq_mes`;

CREATE TABLE `invent_estoq_mes` (
  `inv_ano_mes_invent` int(10) unsigned NOT NULL,
  `inv_cod_prod` int(10) unsigned NOT NULL,
  `inv_qtde` decimal(12,5) NOT NULL,
  PRIMARY KEY (`inv_ano_mes_invent`,`inv_cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `item_ped_cod` int(11) NOT NULL,
  `item_cod` int(11) NOT NULL AUTO_INCREMENT,
  `item_cod_prod` int(11) NOT NULL,
  `item_quantidade` int(11) NOT NULL,
  `item_preco_unit` decimal(7,2) NOT NULL,
  `item_vlr_desc` decimal(7,2) DEFAULT NULL,
  `item_preco_tot` decimal(7,2) DEFAULT NULL,
  `item_stt_meia_pizza` char(1) DEFAULT 'N',
  `item_cod_prod2` int(11) DEFAULT NULL,
  `item_cod_prod3` int(11) DEFAULT NULL,
  `item_cod_borda` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_ped_cod`,`item_cod`),
  KEY `fk_peditem_pedvenda_idx` (`item_ped_cod`),
  KEY `fdk_peditem_produtos_idx` (`item_cod_prod`),
  KEY `item_cod` (`item_cod`),
  KEY `fdk_peditem_produtos2` (`item_cod_prod2`),
  KEY `fdk_peditem_produtos3` (`item_cod_prod3`),
  KEY `fdk_peditem_borda` (`item_cod_borda`),
  CONSTRAINT `fdk_peditem_borda` FOREIGN KEY (`item_cod_borda`) REFERENCES `produtos` (`prd_prod`),
  CONSTRAINT `fdk_peditem_produtos` FOREIGN KEY (`item_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fdk_peditem_produtos2` FOREIGN KEY (`item_cod_prod2`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fdk_peditem_produtos3` FOREIGN KEY (`item_cod_prod3`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_peditem_pedvenda` FOREIGN KEY (`item_ped_cod`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `item_nf_entrada` */

DROP TABLE IF EXISTS `item_nf_entrada`;

CREATE TABLE `item_nf_entrada` (
  `nfei_nro_nf` int(10) unsigned NOT NULL,
  `nfei_ser` char(3) NOT NULL,
  `nfei_seq` int(10) unsigned NOT NULL,
  `nfei_cod_forn` int(10) unsigned NOT NULL,
  `nfei_cod_item` int(10) unsigned NOT NULL,
  `nfei_cod_prod` int(10) unsigned NOT NULL,
  `nfei_qtde` decimal(10,3) DEFAULT NULL,
  `nfei_vlr` decimal(10,2) unsigned zerofill DEFAULT NULL,
  `nfei_vlr_desc` decimal(10,2) DEFAULT NULL,
  `nfei_vlr_icms` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`nfei_nro_nf`,`nfei_ser`,`nfei_seq`,`nfei_cod_forn`,`nfei_cod_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `movto_caixa` */

DROP TABLE IF EXISTS `movto_caixa`;

CREATE TABLE `movto_caixa` (
  `mcx_id_Movto_Cxa` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mcx_num_parc_pagar` int(10) unsigned DEFAULT NULL,
  `mcx_num_tit_pagar` int(10) unsigned DEFAULT NULL,
  `mcx_num_parc_receb` int(11) DEFAULT NULL,
  `mcx_num_tit_receb` int(10) unsigned DEFAULT NULL,
  `mcx_tipo_doc` int(10) unsigned NOT NULL,
  `mcx_dt_mov` date NOT NULL,
  `mcx_vlr_doc` decimal(10,2) NOT NULL,
  PRIMARY KEY (`mcx_id_Movto_Cxa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `movto_estoq` */

DROP TABLE IF EXISTS `movto_estoq`;

CREATE TABLE `movto_estoq` (
  `estq_id` int(11) NOT NULL AUTO_INCREMENT,
  `estq_dt_movto` date NOT NULL,
  `estq_cod_prod` int(11) NOT NULL,
  `estq_tipo` int(11) NOT NULL,
  `estq_qtd` decimal(12,5) NOT NULL,
  PRIMARY KEY (`estq_id`),
  KEY `fk_movto_estoq_tipo_movto_estoq_idx` (`estq_tipo`),
  KEY `fk_movto_estoq_produtos_idx` (`estq_cod_prod`),
  CONSTRAINT `fk_movto_estoq_produtos` FOREIGN KEY (`estq_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movto_estoq_tipo_movto_estoq` FOREIGN KEY (`estq_tipo`) REFERENCES `tipo_movto_estoq` (`tme_id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `municipio` */

DROP TABLE IF EXISTS `municipio`;

CREATE TABLE `municipio` (
  `mun_cod` int(11) NOT NULL AUTO_INCREMENT,
  `mun_nome` varchar(40) NOT NULL,
  `mun_uf` char(2) NOT NULL,
  PRIMARY KEY (`mun_cod`),
  KEY `fk_municip_uf_idx` (`mun_uf`),
  KEY `fk_municip_uf_idx1` (`mun_uf`),
  CONSTRAINT `FK_municipio` FOREIGN KEY (`mun_uf`) REFERENCES `uf` (`uf_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabelas de Municipios ';

/*Table structure for table `nf_entrada` */

DROP TABLE IF EXISTS `nf_entrada`;

CREATE TABLE `nf_entrada` (
  `nfe_nro_nf` int(10) unsigned NOT NULL,
  `nfe_ser` char(3) NOT NULL,
  `nfe_seq` int(10) unsigned NOT NULL,
  `nfe_cod_forn` int(10) unsigned NOT NULL,
  `nfe_tp_pagto` int(10) unsigned NOT NULL,
  `nfe_dt_movto` date NOT NULL,
  `nfe_vlr_tot_prod` decimal(10,2) NOT NULL,
  `nfe_vlr_nf` decimal(10,2) NOT NULL,
  `nfe_vlr_desc` decimal(10,2) NOT NULL,
  `nfe_vlr_icms` decimal(10,2) NOT NULL,
  `nfe_dt_emis` date NOT NULL,
  `nfe_hr_emis` char(5) NOT NULL,
  `nfe_dt_receb` date NOT NULL,
  `nfe_stt_canc` char(1) NOT NULL COMMENT 'S/N',
  `nfe_dt_canc` datetime DEFAULT NULL,
  PRIMARY KEY (`nfe_nro_nf`,`nfe_ser`,`nfe_seq`,`nfe_cod_forn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `nf_entrada_titulos_pagar` */

DROP TABLE IF EXISTS `nf_entrada_titulos_pagar`;

CREATE TABLE `nf_entrada_titulos_pagar` (
  `nfet_cod_forn` int(10) unsigned NOT NULL,
  `nfet_seq` int(10) unsigned NOT NULL,
  `nfet_ser` char(3) NOT NULL,
  `nfet_nro_nf` int(10) unsigned NOT NULL,
  `nfet_num_tit_pagar` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nfet_cod_forn`,`nfet_seq`,`nfet_ser`,`nfet_nro_nf`,`nfet_num_tit_pagar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `ped_cod` int(11) NOT NULL AUTO_INCREMENT,
  `ped_data` date NOT NULL,
  `ped_hr` time NOT NULL,
  `ped_vlr_tot` decimal(7,2) NOT NULL,
  `ped_vlr_desc` decimal(6,2) DEFAULT '0.00',
  `ped_cli_cod` int(11) DEFAULT NULL,
  `ped_stt_canc` char(1) DEFAULT 'N',
  `ped_id_usuario` varchar(15) DEFAULT NULL,
  `ped_obs` varchar(100) DEFAULT NULL,
  `ped_tipo` varchar(1) DEFAULT NULL,
  `ped_pagamento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ped_cod`),
  KEY `fk_pedvenda_cliente_idx` (`ped_cli_cod`),
  KEY `fk_pedvenda_usuario_idx` (`ped_id_usuario`),
  CONSTRAINT `fk_pedvenda_cliente` FOREIGN KEY (`ped_cli_cod`) REFERENCES `cliente` (`cli_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedvenda_usuario` FOREIGN KEY (`ped_id_usuario`) REFERENCES `usuario` (`usu_login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Table structure for table `pedido_pagto` */

DROP TABLE IF EXISTS `pedido_pagto`;

CREATE TABLE `pedido_pagto` (
  `pgto_cod_ped` int(11) NOT NULL,
  `pgto_forma_pagto` int(11) NOT NULL,
  `pgto_vlr` decimal(7,2) NOT NULL,
  PRIMARY KEY (`pgto_cod_ped`,`pgto_forma_pagto`),
  KEY `fk_pedvenda_pagto_pedvenda_idx` (`pgto_cod_ped`),
  KEY `fk_pedvenda_pagto_forma_pagto_idx` (`pgto_forma_pagto`),
  CONSTRAINT `fk_pedvenda_pagto_forma_pagto` FOREIGN KEY (`pgto_forma_pagto`) REFERENCES `tipos_pagto` (`tpgto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedvenda_pagto_pedvenda` FOREIGN KEY (`pgto_cod_ped`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `produtos` */

DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
  `prd_prod` int(11) NOT NULL AUTO_INCREMENT,
  `prd_descr` varchar(100) DEFAULT NULL,
  `prd_id_fornec` int(11) DEFAULT NULL,
  `prd_qtd_min_estoq` decimal(10,4) DEFAULT NULL,
  `prd_stt_avisa_estoq_min` char(1) DEFAULT 'N',
  `prd_vlr_compra` decimal(10,2) DEFAULT NULL,
  `prd_tipo_prod` int(11) DEFAULT NULL,
  `prd_qtd_saldo_estoq` decimal(10,4) DEFAULT NULL,
  `prod_data_cadastro` date DEFAULT NULL,
  `prod_estocavel` char(1) DEFAULT 'S',
  `prd_unid_med` char(2) DEFAULT NULL,
  `prd_acab_prima` char(1) DEFAULT NULL COMMENT 'A=prod.Acabado P=materia-Prima',
  `prd_prod_venda` char(1) DEFAULT NULL COMMENT 'S=Sim N=Não',
  PRIMARY KEY (`prd_prod`),
  KEY `fk_produtos_fornecedor_idx` (`prd_id_fornec`),
  KEY `fk_produtos_tipo_prod_idx` (`prd_tipo_prod`),
  KEY `fk_produtos_unid_med` (`prd_unid_med`),
  CONSTRAINT `fk_produtos_unid_med` FOREIGN KEY (`prd_unid_med`) REFERENCES `unid_medida` (`umed_unid_med`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_tipo_prod` FOREIGN KEY (`prd_tipo_prod`) REFERENCES `tipo_prod` (`tprd_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastro de Produtos';

/*Table structure for table `programas` */

DROP TABLE IF EXISTS `programas`;

CREATE TABLE `programas` (
  `pgm_id` int(11) NOT NULL AUTO_INCREMENT,
  `pgm_nome` varchar(45) NOT NULL,
  `pgm_titulo` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`pgm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `saldo_estoque` */

DROP TABLE IF EXISTS `saldo_estoque`;

CREATE TABLE `saldo_estoque` (
  `sdoe_dt_movto` date NOT NULL,
  `sdoe_cod_prod` int(11) NOT NULL,
  `sdoe_qtd_sdo_ant` decimal(12,5) NOT NULL,
  `sdoe_qtd_ent` decimal(12,5) NOT NULL,
  `sdoe_qtd_sai` decimal(12,5) NOT NULL,
  `sdoe_qtd_sdo_atu` decimal(12,5) NOT NULL,
  PRIMARY KEY (`sdoe_dt_movto`,`sdoe_cod_prod`),
  KEY `fk_saldo_estoque_produtos` (`sdoe_cod_prod`),
  CONSTRAINT `fk_saldo_estoque_produtos` FOREIGN KEY (`sdoe_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tab_precos_venda` */

DROP TABLE IF EXISTS `tab_precos_venda`;

CREATE TABLE `tab_precos_venda` (
  `tprc_cod_prod` int(11) NOT NULL,
  `tprc_vigencia` date NOT NULL,
  `tprc_preco` decimal(8,2) NOT NULL,
  PRIMARY KEY (`tprc_cod_prod`,`tprc_vigencia`),
  KEY `tab_preco_produto_idx` (`tprc_cod_prod`),
  CONSTRAINT `fk_tab_preco_produtos` FOREIGN KEY (`tprc_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tipo_movto_estoq` */

DROP TABLE IF EXISTS `tipo_movto_estoq`;

CREATE TABLE `tipo_movto_estoq` (
  `tme_id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `tme_descr` varchar(45) NOT NULL,
  `tme_stt_ent_sai` char(1) NOT NULL COMMENT 'E=Entrada S=Saida',
  PRIMARY KEY (`tme_id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `tipo_prod` */

DROP TABLE IF EXISTS `tipo_prod`;

CREATE TABLE `tipo_prod` (
  `tprd_id` int(11) NOT NULL AUTO_INCREMENT,
  `tprd_descr` varchar(25) NOT NULL,
  `tprd_stt_pizza` char(1) DEFAULT 'N',
  PRIMARY KEY (`tprd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastros dos Tipos de Produtos';

/*Table structure for table `tipo_receb` */

DROP TABLE IF EXISTS `tipo_receb`;

CREATE TABLE `tipo_receb` (
  `tpr_receb` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tpr_descr` char(20) NOT NULL,
  PRIMARY KEY (`tpr_receb`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `tipos_doctos` */

DROP TABLE IF EXISTS `tipos_doctos`;

CREATE TABLE `tipos_doctos` (
  `tpd_tipo_doc` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tpd_descr` varchar(60) NOT NULL,
  `tpd_descr_resu` char(10) NOT NULL,
  `tpd_stt_ent_sai` char(1) NOT NULL COMMENT 'E=Entrada S=Saida',
  PRIMARY KEY (`tpd_tipo_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tipos_pagto` */

DROP TABLE IF EXISTS `tipos_pagto`;

CREATE TABLE `tipos_pagto` (
  `tpgto_id` int(11) NOT NULL AUTO_INCREMENT,
  `tpgto_descr` varchar(20) NOT NULL,
  PRIMARY KEY (`tpgto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `titulos_pagar` */

DROP TABLE IF EXISTS `titulos_pagar`;

CREATE TABLE `titulos_pagar` (
  `tpg_num_tit_pagar` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tpg_dt_movto` date NOT NULL,
  `tpg_tipo_doc` int(10) unsigned NOT NULL,
  `tpg_vlr_tot_titulo` decimal(10,2) DEFAULT NULL,
  `tpg_vlr_entrada` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`tpg_num_tit_pagar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `titulos_pagar_parc` */

DROP TABLE IF EXISTS `titulos_pagar_parc`;

CREATE TABLE `titulos_pagar_parc` (
  `tpgp_num_tit_pagar` int(10) unsigned NOT NULL,
  `tpgp_num_parc_pagar` int(10) unsigned NOT NULL,
  `tpgp_cod_pagto` int(10) unsigned NOT NULL,
  `tpgpvlr_parc` decimal(10,2) NOT NULL,
  `tpgp_dt_venc` date NOT NULL,
  `tpgp_dt_pagto` date DEFAULT NULL,
  `tpgp_vlr_juros` decimal(10,2) DEFAULT NULL,
  `tpgp_vlr_desc` decimal(10,2) DEFAULT NULL,
  `tpgp_vlr_multa` decimal(10,2) DEFAULT NULL,
  `tpgp_vlr_pago` decimal(10,2) DEFAULT NULL,
  `tpgp_bco_cheq` int(10) unsigned DEFAULT NULL,
  `tpgp_age_cheq` char(10) DEFAULT NULL,
  `tpgp_cta_cheq` char(10) DEFAULT NULL,
  `tpgp_nro_cheq` char(20) DEFAULT NULL,
  `tpgp_obs` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`tpgp_num_tit_pagar`,`tpgp_num_parc_pagar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `titulos_receb` */

DROP TABLE IF EXISTS `titulos_receb`;

CREATE TABLE `titulos_receb` (
  `trc_num_tit_receb` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trc_dt_movto` date NOT NULL,
  `trc_tipo_doc` int(10) unsigned NOT NULL,
  `trc_vlr_tot_titulo` decimal(10,2) NOT NULL,
  `trc_vlr_entrada` decimal(10,2) NOT NULL,
  PRIMARY KEY (`trc_num_tit_receb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `titulos_receb_parc` */

DROP TABLE IF EXISTS `titulos_receb_parc`;

CREATE TABLE `titulos_receb_parc` (
  `trcp_num_tit_receb` int(10) unsigned NOT NULL,
  `trcp_num_parc_receb` int(11) NOT NULL,
  `trcp_tp_receb` int(10) unsigned NOT NULL,
  `trcp_vlr_parc` decimal(10,2) DEFAULT NULL,
  `trcp_dt_venc` date DEFAULT NULL,
  `trcp_dt_recbto` date DEFAULT NULL,
  `trcp_vlr_juros` decimal(10,2) NOT NULL,
  `trcp_vlr_desc` decimal(10,2) DEFAULT NULL,
  `trcp_vlr_multa` decimal(10,2) DEFAULT NULL,
  `trcp_vlr_recebido` decimal(10,2) DEFAULT NULL,
  `trcp_bco_cheq` int(10) unsigned DEFAULT NULL,
  `trcp_age_cheq` char(10) DEFAULT NULL,
  `trcp_cta_cheq` char(10) DEFAULT NULL,
  `trcp_nro_cheq` char(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `trcp_obs` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`trcp_num_tit_receb`,`trcp_num_parc_receb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `uf` */

DROP TABLE IF EXISTS `uf`;

CREATE TABLE `uf` (
  `uf_cod` char(2) NOT NULL,
  `uf_nome` varchar(25) NOT NULL,
  PRIMARY KEY (`uf_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `unid_medida` */

DROP TABLE IF EXISTS `unid_medida`;

CREATE TABLE `unid_medida` (
  `umed_unid_med` char(3) NOT NULL,
  `umed_descr` varchar(20) NOT NULL,
  PRIMARY KEY (`umed_unid_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usu_login` varchar(45) NOT NULL,
  `usu_senha` varchar(45) NOT NULL,
  `status_ai` char(1) NOT NULL DEFAULT 'A' COMMENT 'Status indica se o usuario esta Ativo ou Inativo para utilização do Sistema.',
  `usu_fun_cod` int(11) NOT NULL,
  PRIMARY KEY (`usu_login`),
  KEY `fk_usuario_funcionario_idx` (`usu_fun_cod`),
  CONSTRAINT `fk_usuario_funcionario` FOREIGN KEY (`usu_fun_cod`) REFERENCES `funcionario` (`fun_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de Usuarios do Sistema';

/*Table structure for table `usuario_programas` */

DROP TABLE IF EXISTS `usuario_programas`;

CREATE TABLE `usuario_programas` (
  `upg_login` varchar(45) NOT NULL,
  `upg_id_pgm` int(11) NOT NULL,
  PRIMARY KEY (`upg_login`,`upg_id_pgm`),
  KEY `fk_usu_mod_sist_usu_idx` (`upg_login`),
  KEY `fd_usu_mod_sist_mod_sist_idx` (`upg_id_pgm`),
  CONSTRAINT `fd_usu_mod_sist_mod_sist` FOREIGN KEY (`upg_id_pgm`) REFERENCES `programas` (`pgm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usu_mod_sist_usu` FOREIGN KEY (`upg_login`) REFERENCES `usuario` (`usu_login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de relacionamento Usuario X Modulo do Sistema';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
