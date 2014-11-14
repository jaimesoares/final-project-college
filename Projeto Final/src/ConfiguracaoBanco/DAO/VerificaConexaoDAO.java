/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoBanco.DAO;

import ConfiguracaoBanco.FACTORY.ConnectionFactory;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificaConexaoDAO {

    static Connection connection;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public boolean VerificaConexao(String newServer, String newPorta, String newSenha) {
        connection = connectionFactory.getConnection(newServer, newPorta, newSenha);
        try {
            if (connection.isValid(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean criaBancoDeDados(String nameDataBase) {
        try {
            Statement statement = connection.createStatement();
            if (!statement.execute("CREATE DATABASE IF NOT EXISTS " + nameDataBase)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean criaTabelas(String dataBase) {
        try {
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE `" + dataBase + "`.`caixa_saldo_dia` (\n"
                    + "  `cxs_dt_movto` date NOT NULL,\n"
                    + "  `cxs_stt_aber_fech` char(1) NOT NULL COMMENT 'A=Aberto  F=Fechado',\n"
                    + "  `cxs_sdo_inicial_dinh` decimal(10,2) NOT NULL,\n"
                    + "  `cxs_sdo_inicial_cheq` decimal(10,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`cxs_dt_movto`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cargo` (\n"
                    + "  `crg_id_cargo` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `crg_descr` varchar(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`crg_id_cargo`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cargos da Empresa';\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cep` (\n"
                    + "  `cep_cod` char(8) NOT NULL,\n"
                    + "  `cep_ender` varchar(100) DEFAULT NULL,\n"
                    + "  `cep_bai` varchar(100) DEFAULT NULL,\n"
                    + "  `cep_cid` varchar(30) DEFAULT NULL,\n"
                    + "  `cep_municip` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`cep_cod`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de CEP e Endereços';\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cliente` (\n"
                    + "  `cli_cod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `cli_nome` varchar(50) NOT NULL,\n"
                    + "  `cli_cep` char(8) NOT NULL,\n"
                    + "  `cli_nro_ender` int(11) NOT NULL,\n"
                    + "  `cli_email` varchar(45) DEFAULT NULL,\n"
                    + "  `cli_telefone` varchar(45) NOT NULL,\n"
                    + "  `cli_tel_cel` varchar(45) DEFAULT NULL,\n"
                    + "  `cli_aniversario` date DEFAULT NULL,\n"
                    + "  `cli_datacad` date DEFAULT NULL,\n"
                    + "  `cli_dt_ult_compra` date DEFAULT NULL COMMENT 'data da ultima compra feita pelo cliente\\\\\\\\n',\n"
                    + "  `cli_stt_inadimp` char(1) DEFAULT 'N',\n"
                    + "  `cli_rua` varchar(50) DEFAULT NULL,\n"
                    + "  `cli_bairro` varchar(50) DEFAULT NULL,\n"
                    + "  `cli_obs` varchar(100) DEFAULT NULL,\n"
                    + "  `cli_cidade` varchar(100) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`cli_cod`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastro dos Clientes';\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cupom_titulos_receb` (\n"
                    + "  `ctrc_cupom` int(10) unsigned NOT NULL,\n"
                    + "  `ctrc_ser` char(3) NOT NULL,\n"
                    + "  `ctrc_seq` int(10) unsigned NOT NULL,\n"
                    + "  `ctrc_num_tit_receb` int(10) unsigned NOT NULL,\n"
                    + "  PRIMARY KEY (`ctrc_cupom`,`ctrc_ser`,`ctrc_seq`,`ctrc_num_tit_receb`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`fech_estoq_mes` (\n"
                    + "  `fec_ano_mes_fech` int(10) unsigned NOT NULL,\n"
                    + "  `fec_cod_prod` int(10) unsigned NOT NULL,\n"
                    + "  `fec_qtde_sdo_inicial` decimal(12,5) NOT NULL,\n"
                    + "  PRIMARY KEY (`fec_ano_mes_fech`,`fec_cod_prod`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`invent_estoq_mes` (\n"
                    + "  `inv_ano_mes_invent` int(10) unsigned NOT NULL,\n"
                    + "  `inv_cod_prod` int(10) unsigned NOT NULL,\n"
                    + "  `inv_qtde` decimal(12,5) NOT NULL,\n"
                    + "  PRIMARY KEY (`inv_ano_mes_invent`,`inv_cod_prod`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`item_nf_entrada` (\n"
                    + "  `nfei_nro_nf` int(10) unsigned NOT NULL,\n"
                    + "  `nfei_ser` char(3) NOT NULL,\n"
                    + "  `nfei_seq` int(10) unsigned NOT NULL,\n"
                    + "  `nfei_cod_forn` int(10) unsigned NOT NULL,\n"
                    + "  `nfei_cod_item` int(10) unsigned NOT NULL,\n"
                    + "  `nfei_cod_prod` int(10) unsigned NOT NULL,\n"
                    + "  `nfei_qtde` decimal(10,3) DEFAULT NULL,\n"
                    + "  `nfei_vlr` decimal(10,2) unsigned zerofill DEFAULT NULL,\n"
                    + "  `nfei_vlr_desc` decimal(10,2) DEFAULT NULL,\n"
                    + "  `nfei_vlr_imposto` decimal(10,2) DEFAULT NULL,\n"
                    + "  `nfei_ref_prod` varchar(15) DEFAULT NULL,\n"
                    + "  `nfei_vlr_nf` decimal(10,2) DEFAULT NULL,\n"
                    + "  `nfei_vlr_tot_prod` decimal(10,2) DEFAULT NULL, \n"
                    + "  PRIMARY KEY (`nfei_nro_nf`,`nfei_ser`,`nfei_seq`,`nfei_cod_forn`,`nfei_cod_item`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`movto_caixa` (\n"
                    + "  `mcx_id_Movto_Cxa` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `mcx_num_parc_pagar` int(10) unsigned DEFAULT NULL,\n"
                    + "  `mcx_num_tit_pagar` int(10) unsigned DEFAULT NULL,\n"
                    + "  `mcx_num_parc_receb` int(11) DEFAULT NULL,\n"
                    + "  `mcx_num_tit_receb` int(10) unsigned DEFAULT NULL,\n"
                    + "  `mcx_tipo_doc` int(10) unsigned NOT NULL,\n"
                    + "  `mcx_dt_mov` date NOT NULL,\n"
                    + "  `mcx_vlr_doc` decimal(10,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`mcx_id_Movto_Cxa`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`unid_medida` (\n"
                    + "  `umed_unid_med` char(3) NOT NULL,\n"
                    + "  `umed_descr` varchar(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`umed_unid_med`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`nf_entrada` (\n"
                    + "  `nfe_nro_nf` int(10) unsigned NOT NULL,\n"
                    + "  `nfe_ser` char(3) NOT NULL,\n"
                    + "  `nfe_cod_forn` int(11) unsigned NOT NULL,\n"
                    + "  `nfe_dt_movto` date NOT NULL,\n"
                    + "  `nfe_vlr_tot_prod` decimal(10,2) NOT NULL,\n"
                    + "  `nfe_vlr_nf` decimal(10,2) NOT NULL,\n"
                    + "  `nfe_vlr_desc` decimal(10,2) NOT NULL,\n"
                    + "  `nfe_vlr_imposto` decimal(10,2) NOT NULL,\n"
                    + "  `nfe_dt_emis` date NOT NULL,\n"
                    + "  `nfe_dt_receb` date NOT NULL,\n"
                    + "  `nfe_ped_compra` int(11) DEFAULT NULL COMMENT 'S/N',\n"
                    + "  `nfe_id_usuario` varchar(15) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`nfe_nro_nf`,`nfe_ser`,`nfe_cod_forn`),\n"
                    + "  KEY `fk_entrada_usuario` (`nfe_id_usuario`),\n"
                    + "  CONSTRAINT `fk_entrada_usuario` FOREIGN KEY (`nfe_id_usuario`) REFERENCES `usuario` (`usu_login`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`nf_entrada_titulos_pagar` (\n"
                    + "  `nfet_cod_forn` int(10) unsigned NOT NULL,\n"
                    + "  `nfet_seq` int(10) unsigned NOT NULL,\n"
                    + "  `nfet_ser` char(3) NOT NULL,\n"
                    + "  `nfet_nro_nf` int(10) unsigned NOT NULL,\n"
                    + "  `nfet_num_tit_pagar` int(10) unsigned NOT NULL,\n"
                    + "  PRIMARY KEY (`nfet_cod_forn`,`nfet_seq`,`nfet_ser`,`nfet_nro_nf`,`nfet_num_tit_pagar`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`programas` (\n"
                    + "  `pgm_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `pgm_nome` varchar(45) NOT NULL,\n"
                    + "  `pgm_titulo` varchar(60) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`pgm_id`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`setor` (\n"
                    + "  `set_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `set_descr` varchar(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`set_id`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`status` (\n"
                    + "  `idstatus` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `descricao` varchar(50) NOT NULL,\n"
                    + "  `categorias` varchar(50) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`idstatus`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`titulos_receb_parc` (\n"
                    + "  `trcp_num_tit_receb` int(10) unsigned NOT NULL,\n"
                    + "  `trcp_num_parc_receb` int(11) NOT NULL,\n"
                    + "  `trcp_tp_receb` int(10) unsigned NOT NULL,\n"
                    + "  `trcp_vlr_parc` decimal(10,2) DEFAULT NULL,\n"
                    + "  `trcp_dt_venc` date DEFAULT NULL,\n"
                    + "  `trcp_dt_recbto` date DEFAULT NULL,\n"
                    + "  `trcp_vlr_juros` decimal(10,2) NOT NULL,\n"
                    + "  `trcp_vlr_desc` decimal(10,2) DEFAULT NULL,\n"
                    + "  `trcp_vlr_multa` decimal(10,2) DEFAULT NULL,\n"
                    + "  `trcp_vlr_recebido` decimal(10,2) DEFAULT NULL,\n"
                    + "  `trcp_bco_cheq` int(10) unsigned DEFAULT NULL,\n"
                    + "  `trcp_age_cheq` char(10) DEFAULT NULL,\n"
                    + "  `trcp_cta_cheq` char(10) DEFAULT NULL,\n"
                    + "  `trcp_nro_cheq` char(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,\n"
                    + "  `trcp_obs` varchar(40) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`trcp_num_tit_receb`,`trcp_num_parc_receb`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`uf` (\n"
                    + "  `uf_cod` char(2) NOT NULL,\n"
                    + "  `uf_nome` varchar(25) NOT NULL,\n"
                    + "  PRIMARY KEY (`uf_cod`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tipo_movto_estoq` (\n"
                    + "  `tme_id_tipo` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `tme_descr` varchar(45) NOT NULL,\n"
                    + "  `tme_stt_ent_sai` char(1) NOT NULL COMMENT 'E=Entrada S=Saida',\n"
                    + "  PRIMARY KEY (`tme_id_tipo`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tipo_prod` (\n"
                    + "  `tprd_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `tprd_descr` varchar(25) NOT NULL,\n"
                    + "  `tprd_stt_pizza` char(1) DEFAULT 'N',\n"
                    + "  PRIMARY KEY (`tprd_id`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastros dos Tipos de Produtos';\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tipo_receb` (\n"
                    + "  `tpr_receb` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `tpr_descr` char(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`tpr_receb`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tipos_doctos` (\n"
                    + "  `tpd_tipo_doc` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `tpd_descr` varchar(60) NOT NULL,\n"
                    + "  `tpd_descr_resu` char(10) NOT NULL,\n"
                    + "  `tpd_stt_ent_sai` char(1) NOT NULL COMMENT 'E=Entrada S=Saida',\n"
                    + "  PRIMARY KEY (`tpd_tipo_doc`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tipos_pagto` (\n"
                    + "  `tpgto_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `tpgto_descr` varchar(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`tpgto_id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`titulos_pagar` (\n"
                    + "  `tpg_num_tit_pagar` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `tpg_dt_movto` date NOT NULL,\n"
                    + "  `tpg_tipo_doc` int(10) unsigned NOT NULL,\n"
                    + "  `tpg_vlr_tot_titulo` decimal(10,2) DEFAULT NULL,\n"
                    + "  `tpg_vlr_entrada` decimal(10,2) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`tpg_num_tit_pagar`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`titulos_pagar_parc` (\n"
                    + "  `tpgp_num_tit_pagar` int(10) unsigned NOT NULL,\n"
                    + "  `tpgp_num_parc_pagar` int(10) unsigned NOT NULL,\n"
                    + "  `tpgp_cod_pagto` int(10) unsigned NOT NULL,\n"
                    + "  `tpgpvlr_parc` decimal(10,2) NOT NULL,\n"
                    + "  `tpgp_dt_venc` date NOT NULL,\n"
                    + "  `tpgp_dt_pagto` date DEFAULT NULL,\n"
                    + "  `tpgp_vlr_juros` decimal(10,2) DEFAULT NULL,\n"
                    + "  `tpgp_vlr_desc` decimal(10,2) DEFAULT NULL,\n"
                    + "  `tpgp_vlr_multa` decimal(10,2) DEFAULT NULL,\n"
                    + "  `tpgp_vlr_pago` decimal(10,2) DEFAULT NULL,\n"
                    + "  `tpgp_bco_cheq` int(10) unsigned DEFAULT NULL,\n"
                    + "  `tpgp_age_cheq` char(10) DEFAULT NULL,\n"
                    + "  `tpgp_cta_cheq` char(10) DEFAULT NULL,\n"
                    + "  `tpgp_nro_cheq` char(20) DEFAULT NULL,\n"
                    + "  `tpgp_obs` varchar(40) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`tpgp_num_tit_pagar`,`tpgp_num_parc_pagar`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`titulos_receb` (\n"
                    + "  `trc_num_tit_receb` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `trc_dt_movto` date NOT NULL,\n"
                    + "  `trc_tipo_doc` int(10) unsigned NOT NULL,\n"
                    + "  `trc_vlr_tot_titulo` decimal(10,2) NOT NULL,\n"
                    + "  `trc_vlr_entrada` decimal(10,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`trc_num_tit_receb`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`empresa` (\n"
                    + "  `emp_id_empresa` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `emp_cod_pfj` decimal(15,0) NOT NULL,\n"
                    + "  `emp_fis_jur_emp` varchar(15) DEFAULT NULL COMMENT 'Identifica se o cod_pfj ',\n"
                    + "  `emp_cep` decimal(8,0) NOT NULL,\n"
                    + "  `emp_raz_emp` varchar(45) NOT NULL,\n"
                    + "  `emp_fantasia_emp` varchar(20) NOT NULL COMMENT 'nome fantasia da emprea',\n"
                    + "  `emp_nro_ender` int(11) NOT NULL,\n"
                    + "  `emp_inscr_est` varchar(20) DEFAULT NULL COMMENT 'inscricao estadual da empresa',\n"
                    + "  `emp_tel1` varchar(15) DEFAULT NULL,\n"
                    + "  `emp_tel2` varchar(15) DEFAULT NULL,\n"
                    + "  `emp_tel_cel` varchar(15) DEFAULT NULL,\n"
                    + "  `emp_tel_cel2` varchar(15) DEFAULT NULL,\n"
                    + "  `emp_email` varchar(45) DEFAULT NULL,\n"
                    + "  `emp_site` varchar(45) DEFAULT NULL,\n"
                    + "  `emp_dt_movto` date DEFAULT NULL,\n"
                    + "  `emp_bairro` varchar(30) DEFAULT NULL,\n"
                    + "  `emp_estado` varchar(20) DEFAULT NULL,\n"
                    + "  `emp_cidade` varchar(20) DEFAULT NULL,\n"
                    + "  `emp_rua` varchar(50) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`emp_id_empresa`),\n"
                    + "  KEY `fk_empresa_cep_idx` (`emp_cep`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabela com dados da  Empresa';\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`fornecedor` (\n"
                    + "  `for_id_fornec` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `for_nome` varchar(45) DEFAULT NULL,\n"
                    + "  `for_cod_pfj` decimal(17,0) DEFAULT NULL,\n"
                    + "  `for_cep` char(8) DEFAULT NULL,\n"
                    + "  `for_nro_ender` int(11) DEFAULT NULL,\n"
                    + "  `for_email` varchar(45) DEFAULT NULL,\n"
                    + "  `for_tel` varchar(15) DEFAULT NULL,\n"
                    + "  `for_tel_cel` varchar(15) DEFAULT NULL,\n"
                    + "  `for_dt_cad` date DEFAULT NULL,\n"
                    + "  `for_contato` varchar(60) DEFAULT NULL,\n"
                    + "  `for_ender` varchar(60) DEFAULT NULL,\n"
                    + "  `for_bairro` varchar(60) DEFAULT NULL,\n"
                    + "  `for_cidade` varchar(20) DEFAULT NULL,\n"
                    + "  `for_estado` varchar(20) DEFAULT NULL,\n"
                    + "  `for_status` varchar(17) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`for_id_fornec`),\n"
                    + "  KEY `fk_fornecedor_cep_idx` (`for_cep`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabela de dados dos Fornecedores';\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`funcionario` (\n"
                    + "  `fun_codigo` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `fun_nome` varchar(50) NOT NULL,\n"
                    + "  `fun_dt_admis` date DEFAULT NULL,\n"
                    + "  `fun_dt_demis` date DEFAULT NULL,\n"
                    + "  `fun_nro_ender` int(11) NOT NULL,\n"
                    + "  `fun_cpf` varchar(14) DEFAULT NULL,\n"
                    + "  `fun_rg` varchar(20) DEFAULT NULL,\n"
                    + "  `fun_tel` varchar(15) DEFAULT NULL,\n"
                    + "  `tel_cel` varchar(15) DEFAULT NULL,\n"
                    + "  `fun_email` varchar(45) DEFAULT NULL,\n"
                    + "  `fun_cargo` int(11) NOT NULL,\n"
                    + "  `fun_salario` decimal(7,2) DEFAULT NULL,\n"
                    + "  `fun_vale_transp` decimal(6,2) DEFAULT NULL,\n"
                    + "  `fun_vale_refeicao` decimal(6,2) DEFAULT NULL,\n"
                    + "  `fun_ctps` varchar(20) DEFAULT NULL,\n"
                    + "  `fun_id_empresa` int(11) NOT NULL,\n"
                    + "  `fun_permissao` char(1) DEFAULT NULL,\n"
                    + "  `fun_nascimento` date DEFAULT NULL,\n"
                    + "  `fun_rua` varchar(100) DEFAULT NULL,\n"
                    + "  `fun_cep` char(8) DEFAULT NULL,\n"
                    + "  `fun_bairro` varchar(50) DEFAULT NULL,\n"
                    + "  `fun_cidade` varchar(50) DEFAULT NULL,\n"
                    + "  `fun_estado` varchar(2) DEFAULT NULL,\n"
                    + "  `fun_moto` varchar(30) DEFAULT NULL,\n"
                    + "  `fun_cnh` varchar(30) DEFAULT NULL,\n"
                    + "  `fun_placa_moto` varchar(30) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`fun_codigo`),\n"
                    + "  KEY `fk_funcionario_cargo_idx` (`fun_cargo`),\n"
                    + "  CONSTRAINT `fk_funcionario_cargo` FOREIGN KEY (`fun_cargo`) REFERENCES `cargo` (`crg_id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabela de Funcionarios da Empresa';\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`municipio` (\n"
                    + "  `mun_cod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `mun_nome` varchar(40) NOT NULL,\n"
                    + "  `mun_uf` char(2) NOT NULL,\n"
                    + "  PRIMARY KEY (`mun_cod`),\n"
                    + "  KEY `fk_municip_uf_idx` (`mun_uf`),\n"
                    + "  CONSTRAINT `FK_municipio` FOREIGN KEY (`mun_uf`) REFERENCES `uf` (`uf_cod`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabelas de Municipios ';\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`produtos` (\n"
                    + "  `prd_prod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `prd_descr` varchar(100) DEFAULT NULL,\n"
                    + "  `prd_id_fornec` int(11) DEFAULT NULL,\n"
                    + "  `prd_qtd_min_estoq` decimal(10,4) DEFAULT NULL,\n"
                    + "  `prd_stt_avisa_estoq_min` char(1) DEFAULT 'N',\n"
                    + "  `prd_vlr_compra` decimal(10,2) DEFAULT NULL,\n"
                    + "  `prd_tipo_prod` int(11) DEFAULT NULL,\n"
                    + "  `prd_qtd_saldo_estoq` decimal(10,4) DEFAULT NULL,\n"
                    + "  `prod_data_cadastro` date DEFAULT NULL,\n"
                    + "  `prod_estocavel` char(1) DEFAULT 'S',\n"
                    + "  `prd_unid_med` char(2) DEFAULT NULL,\n"
                    + "  `prd_acab_prima` char(1) DEFAULT NULL COMMENT 'A=prod.Acabado P=materia-Prima',\n"
                    + "  `prd_prod_venda` char(1) DEFAULT 'N' COMMENT 'S=Sim N=Não',\n"
                    + "  `prd_ingrediente` varchar(150) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`prd_prod`),\n"
                    + "  KEY `fk_produtos_fornecedor_idx` (`prd_id_fornec`),\n"
                    + "  KEY `fk_produtos_tipo_prod_idx` (`prd_tipo_prod`),\n"
                    + "  KEY `fk_produtos_unid_med` (`prd_unid_med`),\n"
                    + "  CONSTRAINT `fk_produtos_tipo_prod` FOREIGN KEY (`prd_tipo_prod`) REFERENCES `tipo_prod` (`tprd_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_produtos_unid_med` FOREIGN KEY (`prd_unid_med`) REFERENCES `unid_medida` (`umed_unid_med`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastro de Produtos';\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("\n"
                    + "CREATE TABLE `" + dataBase + "`.`ajuste_estoq` (\n"
                    + "  `aju_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `aju_dt_movto` date NOT NULL,\n"
                    + "  `aju_cod_prod` int(11) NOT NULL,\n"
                    + "  `aju_tipo_movto` int(11) NOT NULL,\n"
                    + "  `aju_qtd` decimal(12,5) NOT NULL,\n"
                    + "  `aju_cod_func` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`aju_id`),\n"
                    + "  KEY `fk_ajuste_produtos` (`aju_cod_prod`),\n"
                    + "  KEY `fk_ajuste_tipo_movto` (`aju_tipo_movto`),\n"
                    + "  KEY `fk_ajuste_funcionario` (`aju_cod_func`),\n"
                    + "  CONSTRAINT `fk_ajuste_funcionario` FOREIGN KEY (`aju_cod_func`) REFERENCES `funcionario` (`fun_codigo`),\n"
                    + "  CONSTRAINT `fk_ajuste_produtos` FOREIGN KEY (`aju_cod_prod`) REFERENCES `produtos` (`prd_prod`),\n"
                    + "  CONSTRAINT `fk_ajuste_tipo_movto` FOREIGN KEY (`aju_tipo_movto`) REFERENCES `tipo_movto_estoq` (`tme_id_tipo`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`requis_estoq` (\n"
                    + "  `req_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `req_dt_movto` date NOT NULL,\n"
                    + "  `req_setor` int(11) NOT NULL,\n"
                    + "  `req_cod_prod` int(11) NOT NULL,\n"
                    + "  `req_tipo_movto` int(11) NOT NULL,\n"
                    + "  `req_qtd` decimal(12,5) NOT NULL,\n"
                    + "  `req_cod_func` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`req_id`),\n"
                    + "  KEY `fk_requis_setor` (`req_setor`),\n"
                    + "  KEY `fk_requis_tpmovto` (`req_tipo_movto`),\n"
                    + "  KEY `fk_requis_produto` (`req_cod_prod`),\n"
                    + "  KEY `fk_requis_funcionario` (`req_cod_func`),\n"
                    + "  CONSTRAINT `fk_requis_funcionario` FOREIGN KEY (`req_cod_func`) REFERENCES `funcionario` (`fun_codigo`),\n"
                    + "  CONSTRAINT `fk_requis_produto` FOREIGN KEY (`req_cod_prod`) REFERENCES `produtos` (`prd_prod`),\n"
                    + "  CONSTRAINT `fk_requis_setor` FOREIGN KEY (`req_setor`) REFERENCES `setor` (`set_id`),\n"
                    + "  CONSTRAINT `fk_requis_tpmovto` FOREIGN KEY (`req_tipo_movto`) REFERENCES `tipo_movto_estoq` (`tme_id_tipo`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`saldo_estoque` (\n"
                    + "  `sdoe_dt_movto` date NOT NULL,\n"
                    + "  `sdoe_cod_prod` int(11) NOT NULL,\n"
                    + "  `sdoe_qtd_sdo_ant` decimal(12,5) NOT NULL,\n"
                    + "  `sdoe_qtd_ent` decimal(12,5) NOT NULL,\n"
                    + "  `sdoe_qtd_sai` decimal(12,5) NOT NULL,\n"
                    + "  `sdoe_qtd_sdo_atu` decimal(12,5) NOT NULL,\n"
                    + "  `sdoe_nro_docto` int(11) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`sdoe_dt_movto`,`sdoe_cod_prod`),\n"
                    + "  KEY `fk_saldo_estoque_produtos` (`sdoe_cod_prod`),\n"
                    + "  CONSTRAINT `fk_saldo_estoque_produtos` FOREIGN KEY (`sdoe_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`tab_precos_venda` (\n"
                    + "  `tprc_cod_prod` int(11) NOT NULL,\n"
                    + "  `tprc_vigencia` date NOT NULL,\n"
                    + "  `tprc_preco` decimal(8,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`tprc_cod_prod`,`tprc_vigencia`),\n"
                    + "  KEY `tab_preco_produto_idx` (`tprc_cod_prod`),\n"
                    + "  CONSTRAINT `fk_tab_preco_produtos` FOREIGN KEY (`tprc_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`usuario` (\n"
                    + "  `usu_login` varchar(45) NOT NULL,\n"
                    + "  `usu_senha` varchar(45) NOT NULL,\n"
                    + "  `status_ai` char(1) NOT NULL DEFAULT 'A' COMMENT 'Status indica se o usuario esta Ativo ou Inativo para utilização do Sistema.',\n"
                    + "  `usu_fun_cod` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`usu_login`),\n"
                    + "  KEY `fk_usuario_funcionario_idx` (`usu_fun_cod`),\n"
                    + "  CONSTRAINT `fk_usuario_funcionario` FOREIGN KEY (`usu_fun_cod`) REFERENCES `funcionario` (`fun_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de Usuarios do Sistema';\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`pedido` (\n"
                    + "  `ped_cod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `ped_data` date NOT NULL,\n"
                    + "  `ped_hr` time NOT NULL,\n"
                    + "  `ped_vlr_tot` decimal(7,2) NOT NULL,\n"
                    + "  `ped_vlr_desc` decimal(6,2) DEFAULT '0.00',\n"
                    + "  `ped_cli_cod` int(11) DEFAULT NULL,\n"
                    + "  `ped_stt_canc` char(1) DEFAULT 'N',\n"
                    + "  `ped_id_usuario` varchar(15) DEFAULT NULL,\n"
                    + "  `ped_obs` varchar(100) DEFAULT NULL,\n"
                    + "  `ped_tipo` varchar(1) DEFAULT NULL,\n"
                    + "  `ped_pagamento` varchar(30) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`ped_cod`),\n"
                    + "  KEY `fk_pedvenda_cliente_idx` (`ped_cli_cod`),\n"
                    + "  KEY `fk_pedvenda_usuario_idx` (`ped_id_usuario`),\n"
                    + "  CONSTRAINT `fk_pedvenda_cliente` FOREIGN KEY (`ped_cli_cod`) REFERENCES `cliente` (`cli_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_pedvenda_usuario` FOREIGN KEY (`ped_id_usuario`) REFERENCES `usuario` (`usu_login`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`item` (\n"
                    + "  `item_ped_cod` int(11) NOT NULL,\n"
                    + "  `item_cod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `item_cod_prod` int(11) NOT NULL,\n"
                    + "  `item_quantidade` int(11) NOT NULL,\n"
                    + "  `item_preco_unit` decimal(7,2) NOT NULL,\n"
                    + "  `item_vlr_desc` decimal(7,2) DEFAULT NULL,\n"
                    + "  `item_preco_tot` decimal(7,2) DEFAULT NULL,\n"
                    + "  `item_stt_meia_pizza` char(1) DEFAULT 'N',\n"
                    + "  `item_cod_prod2` int(11) DEFAULT NULL,\n"
                    + "  `item_cod_prod3` int(11) DEFAULT NULL,\n"
                    + "  `item_cod_borda` int(11) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`item_ped_cod`,`item_cod`),\n"
                    + "  KEY `fk_peditem_pedvenda_idx` (`item_ped_cod`),\n"
                    + "  KEY `fdk_peditem_produtos_idx` (`item_cod_prod`),\n"
                    + "  KEY `item_cod` (`item_cod`),\n"
                    + "  KEY `fdk_peditem_produtos2` (`item_cod_prod2`),\n"
                    + "  KEY `fdk_peditem_produtos3` (`item_cod_prod3`),\n"
                    + "  KEY `fdk_peditem_borda` (`item_cod_borda`),\n"
                    + "  CONSTRAINT `fdk_peditem_borda` FOREIGN KEY (`item_cod_borda`) REFERENCES `produtos` (`prd_prod`),\n"
                    + "  CONSTRAINT `fdk_peditem_produtos` FOREIGN KEY (`item_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fdk_peditem_produtos2` FOREIGN KEY (`item_cod_prod2`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fdk_peditem_produtos3` FOREIGN KEY (`item_cod_prod3`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_peditem_pedvenda` FOREIGN KEY (`item_ped_cod`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`pedido_pagto` (\n"
                    + "  `pgto_cod_ped` int(11) NOT NULL,\n"
                    + "  `pgto_forma_pagto` int(11) NOT NULL,\n"
                    + "  `pgto_vlr` decimal(7,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`pgto_cod_ped`,`pgto_forma_pagto`),\n"
                    + "  KEY `fk_pedvenda_pagto_pedvenda_idx` (`pgto_cod_ped`),\n"
                    + "  KEY `fk_pedvenda_pagto_forma_pagto_idx` (`pgto_forma_pagto`),\n"
                    + "  CONSTRAINT `fk_pedvenda_pagto_forma_pagto` FOREIGN KEY (`pgto_forma_pagto`) REFERENCES `tipos_pagto` (`tpgto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_pedvenda_pagto_pedvenda` FOREIGN KEY (`pgto_cod_ped`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cupom` (\n"
                    + "  `cup_cod_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `cup_vlr` decimal(8,2) NOT NULL,\n"
                    + "  `cup_tributos` decimal(7,2) DEFAULT NULL,\n"
                    + "  `cup_dt_emissao` date NOT NULL,\n"
                    + "  `cup_hr_emissao` time NOT NULL,\n"
                    + "  `cup_ped_cod` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`cup_cod_id`),\n"
                    + "  KEY `fk_cupom_pedido_idx` (`cup_ped_cod`),\n"
                    + "  CONSTRAINT `fk_cupom_pedido` FOREIGN KEY (`cup_ped_cod`) REFERENCES `pedido` (`ped_cod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`cupom_item` (\n"
                    + "  `cupi_cod_cup` int(11) NOT NULL,\n"
                    + "  `cupi_cod` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `cupi_cod_prod` int(11) NOT NULL,\n"
                    + "  `cupi_qtd` int(11) NOT NULL,\n"
                    + "  `cupi_vlr_unit` decimal(6,2) NOT NULL,\n"
                    + "  `cupi_vlr_tot` decimal(8,2) NOT NULL,\n"
                    + "  `cupi_vlr_desc` decimal(7,2) DEFAULT NULL,\n"
                    + "  `cupi_vlr_tributo` decimal(7,2) DEFAULT NULL,\n"
                    + "  `cupi_cod_prod2` int(11) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`cupi_cod_cup`,`cupi_cod`),\n"
                    + "  KEY `fk_cupom_item_produto_idx` (`cupi_cod_prod`),\n"
                    + "  KEY `fk_cupom_item_cupom_idx` (`cupi_cod_cup`),\n"
                    + "  KEY `cupi_cod` (`cupi_cod`),\n"
                    + "  CONSTRAINT `fk_cupom_item_cupom` FOREIGN KEY (`cupi_cod_cup`) REFERENCES `cupom` (`cup_cod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_cupom_item_produto` FOREIGN KEY (`cupi_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`movto_estoq` (\n"
                    + "  `estq_id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `estq_dt_movto` date NOT NULL,\n"
                    + "  `estq_cod_prod` int(11) NOT NULL,\n"
                    + "  `estq_tipo` int(11) NOT NULL,\n"
                    + "  `estq_qtd` decimal(12,5) NOT NULL,\n"
                    + "  PRIMARY KEY (`estq_id`),\n"
                    + "  KEY `fk_movto_estoq_tipo_movto_estoq_idx` (`estq_tipo`),\n"
                    + "  KEY `fk_movto_estoq_produtos_idx` (`estq_cod_prod`),\n"
                    + "  CONSTRAINT `fk_movto_estoq_produtos` FOREIGN KEY (`estq_cod_prod`) REFERENCES `produtos` (`prd_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_movto_estoq_tipo_movto_estoq` FOREIGN KEY (`estq_tipo`) REFERENCES `tipo_movto_estoq` (`tme_id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;\n"
                    + "\n"
                    + "\n");

            statement.execute("CREATE TABLE `" + dataBase + "`.`usuario_programas` (\n"
                    + "  `upg_login` varchar(45) NOT NULL,\n"
                    + "  `upg_id_pgm` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`upg_login`,`upg_id_pgm`),\n"
                    + "  KEY `fk_usu_mod_sist_usu_idx` (`upg_login`),\n"
                    + "  KEY `fd_usu_mod_sist_mod_sist_idx` (`upg_id_pgm`),\n"
                    + "  CONSTRAINT `fd_usu_mod_sist_mod_sist` FOREIGN KEY (`upg_id_pgm`) REFERENCES `programas` (`pgm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `fk_usu_mod_sist_usu` FOREIGN KEY (`upg_login`) REFERENCES `usuario` (`usu_login`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de relacionamento Usuario X Modulo do Sistema';\n"
                    + "\n"
                    + "");

            statement.execute("insert  into `" + dataBase + "`.`cargo`(`crg_id_cargo`,`crg_descr`) values (1,'Gerente'),(3,'Atendente'),(4,'Entregador'),(5,'Manutenção'),(6,'Garçom'),(7,'Pizzaolo'),(8,'Cozinheiro'),(9,'Auxiliar Cozinha'),(10,'Faxineiro');");
            statement.execute("insert into `" + dataBase + "`.`cliente`(`cli_cod`,`cli_nome`,`cli_cep`,`cli_nro_ender`,`cli_email`,`cli_telefone`,`cli_tel_cel`,`cli_aniversario`,`cli_datacad`,`cli_dt_ult_compra`,`cli_stt_inadimp`,`cli_rua`,`cli_bairro`,`cli_obs`,`cli_cidade`) values (1,'Jaime','08142000',3,'jaime@com.br','(11)1111-1111','(  )     -    ','1111-11-11','2014-10-22',NULL,'N','Rua Itajuibe','Jardim Nélia','','São Paulo'),(2,'Edson de Moraes','08150000',1413,'','(11)2539-9140','(  )     -    ','1976-05-31','2014-11-01',NULL,'N','Avenida Teodoro Bernardo do Nascimento','Jardim Robru','','São Paulo'),(3,'Firmino dos Santos','08120610',12,'','(11)2561-8317','(  )     -    ','1980-10-25','2014-11-01',NULL,'N','Rua Jacy Vieira','Jardim Virginia','','São Paulo'),(4,'Cosme','08452430',796,'','(11)1111-1111','(  )     -    ','1990-08-28','2014-11-08',NULL,'N','Rua Francisco de Soutomaior','Jardim Lourdes','		','São Paulo');");
            statement.execute("insert into " + dataBase + ".`unid_medida`(`umed_unid_med`,`umed_descr`) values ('CX','CAIXA'),('DZ','DUZIA'),('GR','GRAMA'),('KG','QUILOGRAMA'),('LT','LITRO'),('UN','UNIDADE');");
            statement.execute("insert into " + dataBase + ".`programas`(`pgm_id`,`pgm_nome`,`pgm_titulo`) values (1,'CADASTRO DE CLIENTES','CadCliente'),(2,'CADASTRO TIPOS DE PRODUTOS','CadTipoProd'),(3,'CADASTRO DE CARGO/FUNCAO','CadCargo'),(4,'CADASTRO DE USUARIOS','CadUsuario'),(5,'CADASTRO DE EMPRESA','CadEmpresa'),(6,'CADASTRO DE TIPO DE PRODUTOS','CadTipoProd'),(7,'CADASTRO DE PRODUTOS','CadProdutos'),(8,'CADASTRO DE PRECOS DE PRODUTOS','CadPrecoProd'),(9,'AJUSTE DE ESTOQUE','AjusteEstoque'),(10,'INCLUIR NF DE ENTRADA','IncNFEntrada'),(11,'EXCLUIR NF DE ENTRADA','ExcNFEntrada'),(12,'REQUISIÇÃO DE MATERIAL','ReqMaterial'),(13,'CADASTRO DE PEDIDOS DE VENDA','CadPedidosVen'),(14,'CANCELA PEDIDOS DE VENDA','CancPedidosVen'),(15,'ENTREGA DE PEDIDOS DE VENDAS','EntregaPedidosVen'),(16,'FECHAMENTO DO DIA DE VENDAS','FechaDiaVendas'),(17,'CADASTRO DE FORNECEDORES','CadFornec'),(18,'CADASTRO DE PEDIDOS DE COMPRA','CadPedidosComp'),(19,'CANCELA PEDIDOS DE COMPRA','CancPedidosComp'),(20,'RELATORIO DE CLIENTES','RelClientes'),(21,'CONSULTA MOVTO DE ESTOQUE','ConsMovtoEstoque'),(22,'BACKUP DOS DADOS','BackupDados');");
            statement.execute("insert into " + dataBase + ".`setor`(`set_id`,`set_descr`) values (1,'COZINHA'),(2,'BALCAO'),(3,'SALAO'),(4,'ALMOXARIFADO');");
            statement.execute("insert into " + dataBase + ".`uf`(`uf_cod`,`uf_nome`) values ('SP','São Paulo');");
            statement.execute("insert into " + dataBase + ".`tipo_movto_estoq`(`tme_id_tipo`,`tme_descr`,`tme_stt_ent_sai`) values (1,'NF VENDAS','S'),(2,'CANC NF VENDAS','E'),(3,'NF ENTRADA','E'),(4,'CANC NF ENTRADA','S'),(5,'REQUISICAO ENTRADA','E'),(6,'REQUISICAO SAIDA','S'),(7,'AJUSTE INVENT ENTRADA','E'),(8,'AJUSTE INVENT SAIDA','S');");
            statement.execute("insert into " + dataBase + ".`tipo_prod`(`tprd_id`,`tprd_descr`,`tprd_stt_pizza`) values (1,'Pizza','S'),(2,'Refrigerante','N'),(3,'Sucos','N'),(4,'Cervejas','N'),(5,'Borda','N'),(6,'Lanches','N'),(7,'Esfihas Aberta','N'),(8,'Vinhos','N'),(9,'Bebidas Diversas','N'),(10,'Ingredientes','N'),(11,'Broto','S');");
            statement.execute("insert into " + dataBase + ".`empresa`(`emp_id_empresa`,`emp_cod_pfj`,`emp_fis_jur_emp`,`emp_cep`,`emp_raz_emp`,`emp_fantasia_emp`,`emp_nro_ender`,`emp_inscr_est`,`emp_tel1`,`emp_tel2`,`emp_tel_cel`,`emp_tel_cel2`,`emp_email`,`emp_site`,`emp_dt_movto`,`emp_bairro`,`emp_estado`,`emp_cidade`,`emp_rua`) values (1,'6286981000161','Pessoa Jurídica','8161380','LANCHONETE E PIZZARIA ARAGÃO LTDA. ME','PizzariaMama',52,NULL,'(  )    -    ','(  )     -    ','(  )    -    ','(  )     -    ','','','2014-11-01','Jardim dos Ipês','SP','São Paulo','Rua dos Igarapés');");
            statement.execute("insert into " + dataBase + ".`fornecedor`(`for_id_fornec`,`for_nome`,`for_cod_pfj`,`for_cep`,`for_nro_ender`,`for_email`,`for_tel`,`for_tel_cel`,`for_dt_cad`,`for_contato`,`for_ender`,`for_bairro`,`for_cidade`,`for_estado`,`for_status`) values (1,'Fulano','54563650000174','08142000',3,'fulano','(11)1111-1111','(  )     -    ','2014-10-31','ciclano','Rua Itajuibe','Jardim Nélia','São Paulo','SP','Inativo'),(2,'Supermecado Baratão','51436154000161','08142000',1105,'supermecadobaratao@baratao.com','(11)2567-8596','(  )     -    ','2014-10-31','Walter','Rua Itajuibe','Jardim Nélia','São Paulo','SP','Ativo');");
            statement.execute("insert into " + dataBase + ".`funcionario`(`fun_codigo`,`fun_nome`,`fun_dt_admis`,`fun_dt_demis`,`fun_nro_ender`,`fun_cpf`,`fun_rg`,`fun_tel`,`tel_cel`,`fun_email`,`fun_cargo`,`fun_salario`,`fun_vale_transp`,`fun_vale_refeicao`,`fun_ctps`,`fun_id_empresa`,`fun_permissao`,`fun_nascimento`,`fun_rua`,`fun_cep`,`fun_bairro`,`fun_cidade`,`fun_estado`,`fun_moto`,`fun_cnh`,`fun_placa_moto`) values (1,'Jaime Soares','2014-09-16',NULL,33,'632.226.776-03','11.134.229-2','(11)2568-7596','(  )     -    ','jaime.sistema@gmail.com',1,NULL,NULL,NULL,NULL,1,NULL,'1985-12-07','Rua Vinte de Novembro','08142380','Jardim Miriam','São Paulo','SP','','','');");
            statement.execute("insert into " + dataBase + ".`municipio`(`mun_cod`,`mun_nome`,`mun_uf`) values (1,'São Paulo','SP');");
            statement.execute("insert into " + dataBase + ".`produtos`(`prd_prod`,`prd_descr`,`prd_id_fornec`,`prd_qtd_min_estoq`,`prd_stt_avisa_estoq_min`,`prd_vlr_compra`,`prd_tipo_prod`,`prd_qtd_saldo_estoq`,`prod_data_cadastro`,`prod_estocavel`,`prd_unid_med`,`prd_acab_prima`,`prd_prod_venda`,`prd_ingrediente`) values (1,'MUSSARELA GRANDE',NULL,'0.0000','N',NULL,1,'0.0000','2014-10-30','N','UN','A','S','MUSSARELA, TOMATE, OREGANO, AZEITONAS'),(2,'MUSSARELA BROTO',NULL,'0.0000','N',NULL,11,'0.0000','2014-10-30','N','UN','A','S','MUSSARELA, TOMATE, OREGANO, AZEITONAS'),(3,'CALABRESA GRANDE',NULL,'0.0000','N',NULL,1,'0.0000','2014-10-30','N','UN','A','S','CALABRESA, CEBOLA, AZEITONAS'),(4,'CALABRESA BROTO',NULL,'0.0000','N',NULL,11,'0.0000','2014-10-30','N','UN','A','S','CALABRESA, CEBOLA, AZEITONAS'),(5,'ATUM GRANDE',NULL,'0.0000','N',NULL,1,'0.0000','2014-10-30','N','UN','A','S','ATUM, CEBOLA, AZEITONAS'),(6,'ATUM BROTO',NULL,'0.0000','N',NULL,11,'0.0000','2014-10-30','N','UN','A','S','ATUM, CEBOLA, AZEITONAS'),(7,'BRASILEIRA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CHAMPIGNON, PALMITO, MILHO, ERVILHA, MUSSARELA, AZEITONAS'),(8,'BRASILEIRA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CHAMPIGNON, PALMITO, MILHO, ERVILHA, MUSSARELA, AZEITONAS'),(9,'A MODA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CALABRESA, FRANGO, MUSSARELA, AZEITONAS'),(10,'A MODA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CALABRESA, FRANGO, MUSSARELA, AZEITONAS'),(11,'BACON GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','BACON, MUSSARELA, AZEITONAS'),(12,'BACON BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','BACON, MUSSARELA, AZEITONAS'),(13,'BAIANA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CALABRESA PICADA, OVOS, PRESUNTO, CEBOLA, PIMENTA, AZEITONAS'),(14,'BAIANA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CALABRESA PICADA, OVOS, PRESUNTO, CEBOLA, PIMENTA, AZEITONAS'),(15,'BAURU GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','PRESUNTO, TOMATE, OREGANO, MUSSARELA, AZEITONAS'),(16,'BAURU BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','PRESUNTO, TOMATE, OREGANO, MUSSARELA, AZEITONAS'),(17,'CAIPIRA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, MILHO, CATUPIRY, AZEITONAS'),(18,'CAIPIRA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, MILHO, CATUPIRY, AZEITONAS'),(19,'CATUFRANGO GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, CATUPIRY, AZEITONAS'),(20,'CATUFRANGO BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, CATUPIRY, AZEITONAS'),(21,'CATUPIRY GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','QUEIJO TIPO CATUPIRY, AZEITONAS'),(22,'CATUPIRY BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','QUEIJO TIPO CATUPIRY, AZEITONAS'),(23,'ESCAROLA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','ESCAROLA, BACON, MUSSARELA, AZEITONAS'),(24,'ESCAROLA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','ESCAROLA, BACON, MUSSARELA, AZEITONAS'),(25,'ESPANHOLA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','LOMBO, PALMITO, CEBOLA, CATUPIRY, PROVOLONE, AZEITONAS'),(26,'ESPANHOLA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','LOMBO, PALMITO, CEBOLA, CATUPIRY, PROVOLONE, AZEITONAS'),(27,'FRANGO GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, MUSSARELA, AZEITONAS'),(28,'FRANGO BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','FRANGO DESFIADO, MUSSARELA, AZEITONAS'),(29,'PORTUGUESA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','PRESUNTO, OVOS, ERVILHA, CEBOLA, PALMITO, MUSSARELA, AZEITONAS'),(30,'PORTUGUESA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','PRESUNTO, OVOS, ERVILHA, CEBOLA, PALMITO, MUSSARELA, AZEITONAS'),(31,'LOMBO GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','LOMBO, CEBOLA, MUSSARELA, AZEITONAS'),(32,'LOMBO BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','LOMBO, CEBOLA, MUSSARELA, AZEITONAS'),(33,'QUATRO QUEIJOS GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','MUSSARELA, CATUPIRY, PROVOLONE, PARMESSAO, AZEITONAS'),(34,'QUATRO QUEIJOS BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','MUSSARELA, CATUPIRY, PROVOLONE, PARMESSAO, AZEITONAS'),(35,'SICILIANA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CHAMPIGNON, MUSSARELA CEBOLA, BACON, TOMATE SECO, AZEITONAS'),(36,'SICILIANA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CHAMPIGNON, MUSSARELA CEBOLA, BACON, TOMATE SECO, AZEITONAS'),(37,'PERUANA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','ATUM, PALMITO, ERVILHA, CEBOLA, MUSSARELA, AZEITONAS'),(38,'PERUANA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','ATUM, PALMITO, ERVILHA, CEBOLA, MUSSARELA, AZEITONAS'),(39,'ROMEU E JULIETA GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','GOIABADA, MUSSARELA'),(40,'ROMEU E JULIETA BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','GOIABADA, MUSSARELA'),(41,'BRIGADEIRO GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CHOCOLATE AO LEITE, CHOCOLATE GRANULADO'),(42,'BRIGADEIRO BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CHOCOLATE AO LEITE, CHOCOLATE GRANULADO'),(43,'PRESTIGIO GRANDE',NULL,'0.0000','N','0.00',1,'0.0000','2014-10-30','N','UN','A','S','CHOCOLATE AO LEITE, COCO RALADO'),(44,'PRESTIGIO BROTO',NULL,'0.0000','N','0.00',11,'0.0000','2014-10-30','N','UN','A','S','CHOCOLATE AO LEITE, COCO RALADO'),(60,'CERVEJA LATA 350ML',NULL,'24.0000','S','0.00',4,'0.0000','2014-10-30','S','UN','A','S',NULL),(61,'CERVEJA LATAO',NULL,'12.0000','S','0.00',4,'0.0000','2014-10-30','S','UN','A','S',NULL),(62,'CERVEJA GARRAFA 600ML',NULL,'12.0000','S','0.00',4,'0.0000','2014-10-30','S','UN','A','S',NULL),(63,'CERVEJA GARRAFA LITRAO',NULL,'12.0000','S','0.00',4,'0.0000','2014-10-30','S','UN','A','S',NULL),(70,'REFRIGERANTE LATA 350',NULL,'6.0000','S','0.00',2,'0.0000','2014-10-30','S','UN','A','S',NULL),(71,'REFRIGERANTE GARRAFA 600ML',NULL,'6.0000','S','0.00',2,'0.0000','2014-10-30','S','UN','A','S',NULL),(72,'REFRIGERANTE GARRAFA 300ML',NULL,'6.0000','S','0.00',2,'0.0000','2014-10-30','S','UN','A','S',NULL),(73,'REFRIGERANTE GARRAFA 2LT',NULL,'6.0000','S','0.00',2,'0.0000','2014-10-30','S','UN','A','S',NULL),(80,'SUCO ABACAXI',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(81,'SUCO LIMAO',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(82,'SUCO MARACUJA',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(83,'SUCO LARANJA',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(84,'SUCO MORANGO',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(85,'SUCO MORANGO C/LEITE',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(86,'SUCO MARACUJA C/LEITE',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(87,'SUCO ABACAXI C/LEITE',NULL,'6.0000','N','0.00',3,'0.0000','2014-10-30','N','UN','A','S',NULL),(90,'AMERICANO',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(91,'BAURU',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(92,'MISTO',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(93,'X-BACON',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(94,'X-SALADA',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(95,'X-EGG',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(96,'X-CALABRESA',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(97,'X-TUDO',NULL,'0.0000','N','0.00',6,'0.0000','2014-10-30','N','UN','A','S',NULL),(100,'FARINHA DE TRIGO',NULL,'10.0000','S','5.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(101,'OVOS',NULL,'12.0000','S','0.00',10,'0.0000','2014-10-30','S','UN','P','N',NULL),(102,'OLEO DE SOJA',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','UN','P','N',NULL),(103,'FERMENTO',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(104,'SAL',NULL,'5.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(105,'EXTRATO DE TOMATE',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(106,'MUSSARELA',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(107,'CATUPIRY',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(108,'PROVOLONE',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(109,'QUEIJO PARMESÃO',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(110,'AZEITONAS',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(111,'CHAMPIGNON',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(112,'QUEIJO GORGONZOLA',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(113,'MILHO EM LATA',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(114,'PRESUNTO',NULL,'10.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(115,'BACON',NULL,'4.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(116,'FRANGO DESFIADO',NULL,'12.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(117,'PEITO DE PERU',NULL,'6.0000','S','0.00',10,'0.0000','2014-10-30','S','KG','P','N',NULL),(118,'PALMITO EM LATA',NULL,'6.0000','S','0.00',10,'0.0000','2014-10-30','S','UN','P','N',NULL),(150,'ESFIHA CARNE',NULL,'0.0000','N','0.00',7,'0.0000','2014-10-30','N','UN','A','S',NULL),(151,'ESFIHA QUEIJO',NULL,'0.0000','N','0.00',7,'0.0000','2014-10-30','N','UN','A','S',NULL),(152,'ESFIHA ATUM',NULL,'0.0000','N','0.00',7,'0.0000','2014-10-30','N','UN','A','S',NULL),(153,'ESFIHA BACON',NULL,'0.0000','N','0.00',7,'0.0000','2014-10-30','N','UN','A','S',NULL),(200,'CATUPIRY',NULL,'0.0000','N','0.00',5,'0.0000','2014-10-30','N','UN','A','S',NULL),(201,'CHEDDAR',NULL,'0.0000','N','0.00',5,'0.0000','2014-10-30','N','UN','A','S',NULL),(202,'MODA CASA',NULL,'0.0000','N',NULL,1,'0.0000','2014-11-08','N','UN','A','S','TUDO, MAIS UM POUCO');");
            statement.execute("insert into " + dataBase + ".`tab_precos_venda`(`tprc_cod_prod`,`tprc_vigencia`,`tprc_preco`) values (1,'2014-10-14','3.50'),(1,'2014-10-30','19.00'),(2,'2014-10-15','5.00'),(2,'2014-10-30','12.00'),(3,'2014-10-15','25.00'),(3,'2014-10-30','19.00'),(4,'2014-10-30','12.00'),(5,'2014-10-30','24.00'),(6,'2014-10-30','16.00'),(7,'2014-10-30','25.00'),(8,'2014-10-30','16.50'),(9,'2014-10-30','24.00'),(10,'2014-10-30','16.00'),(11,'2014-10-30','21.00'),(12,'2014-10-30','14.50'),(13,'2014-10-30','23.00'),(14,'2014-10-30','15.50'),(15,'2014-10-30','22.00'),(16,'2014-10-30','15.00'),(17,'2014-10-30','24.00'),(18,'2014-10-30','16.00'),(19,'2014-10-30','24.00'),(20,'2014-10-30','16.00'),(21,'2014-10-30','23.00'),(22,'2014-10-30','15.50'),(23,'2014-10-30','22.00'),(24,'2014-10-30','14.00'),(25,'2014-10-30','26.00'),(26,'2014-10-30','18.00'),(27,'2014-10-30','22.00'),(28,'2014-10-30','15.00'),(29,'2014-10-30','24.00'),(30,'2014-10-30','16.00'),(31,'2014-10-30','23.00'),(32,'2014-10-30','15.00'),(33,'2014-10-30','25.00'),(34,'2014-10-30','16.00'),(35,'2014-10-30','25.00'),(36,'2014-10-30','16.00'),(37,'2014-10-30','25.00'),(38,'2014-10-30','16.00'),(39,'2014-10-30','22.00'),(41,'2014-10-30','22.00'),(43,'2014-10-30','22.00'),(60,'2014-10-30','3.50'),(61,'2014-10-30','4.50'),(62,'2014-10-30','7.00'),(63,'2014-10-30','9.00'),(70,'2014-10-30','3.00'),(71,'2014-10-30','4.50'),(72,'2014-10-30','2.50'),(73,'2014-10-30','6.00'),(80,'2014-10-30','4.50'),(81,'2014-10-30','4.50'),(82,'2014-10-30','4.50'),(83,'2014-10-30','4.50'),(84,'2014-10-30','4.50'),(85,'2014-10-30','5.00'),(86,'2014-10-30','5.00'),(87,'2014-10-30','5.00'),(90,'2014-10-30','4.50'),(92,'2014-10-30','5.00'),(93,'2014-10-30','5.00'),(94,'2014-10-30','5.00'),(95,'2014-10-30','5.00'),(96,'2014-10-30','5.00'),(97,'2014-10-30','8.00'),(150,'2014-10-30','1.00'),(152,'2014-10-30','1.60'),(200,'2014-10-30','1.50'),(201,'2014-10-30','2.00'),(202,'2014-11-08','150.00');");
            statement.execute("insert into " + dataBase + ".`usuario`(`usu_login`,`usu_senha`,`status_ai`,`usu_fun_cod`) values ('admin','admin','A',1);");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
