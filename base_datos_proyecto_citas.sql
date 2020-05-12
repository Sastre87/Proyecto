create database proyecto_citas;

use proyecto_citas;

CREATE TABLE empleado (
  dni varchar(9) not null,
  nombre varchar(10) NOT NULL,
  apellidos varchar (30) not null,
  password varchar(10) NOT NULL,
  mesa int(2) NOT NULL,
  tipo_tramite int(1) NOT NULL,
  PRIMARY KEY (dni)
  ) ;
  
 
  
  CREATE TABLE usuario (
  dni varchar(9) not null,
  nombre varchar(10) NOT NULL,
  apellidos varchar (30) not null,
  password varchar(10) NOT NULL,
  direccion varchar(20),
  cuenta_bancaria varchar(20),
  fecha_nacimiento varchar(10),
  PRIMARY KEY (dni)
  );
  


  create table tramites(
  id int (1) primary key,
  nombre_tramite varchar (12) not null
  );
 

  
  CREATE TABLE tramite_altas (
  id_alta int(3) not null,
  dni_usuario varchar(9) not null,
  dni_empleado varchar(9) NOT NULL,
  fecha_alta varchar (10) not null,
  tipo_plan varchar(10) NOT NULL,
  precio int(2) NOT NULL,
  tipo_tramite int(1) not null,
  PRIMARY KEY (id_alta),
  KEY emp_alt_fk (dni_empleado),
  KEY usu_alt_fk (dni_usuario),
  KEY tra_alt_fk (tipo_tramite),
  CONSTRAINT emp_alt_fk FOREIGN KEY (dni_empleado) REFERENCES empleado (dni),
  CONSTRAINT usu_alt_fk FOREIGN KEY (dni_usuario) REFERENCES usuario (dni),
  CONSTRAINT tra_alt_fk FOREIGN KEY (tipo_tramite) REFERENCES tramites (id)
  );
  

  
  CREATE TABLE tramite_bajas (
  id_baja int(3) not null,
  dni_usuario varchar(9) not null,
  dni_empleado varchar(9) NOT NULL,
  fecha_baja varchar (10) not null,
  motivo varchar(50) NOT NULL,
  corriente_pago bool NOT NULL,
  tipo_tramite int(1) not null,
  PRIMARY KEY (id_baja),
  KEY emp_baj_fk (dni_empleado),
  KEY usu_baj_fk (dni_usuario),
  KEY tra_baj_fk (tipo_tramite),
  CONSTRAINT emp_baj_fk FOREIGN KEY (dni_empleado) REFERENCES empleado (dni),
  CONSTRAINT usu_baj_fk FOREIGN KEY (dni_usuario) REFERENCES usuario (dni),
  CONSTRAINT tra_baj_fk FOREIGN KEY (tipo_tramite) REFERENCES tramites (id)
  );
  
  
  CREATE TABLE tramite_suspensiones (
  id_suspension int(3) not null,
  dni_usuario varchar(9) not null,
  dni_empleado varchar(9) NOT NULL,
  fecha_ini_sus varchar (10) not null,
  fecha_fin_sus varchar  (10) not null,
  motivo_sus varchar(50) NOT NULL,
  corriente_pago bool NOT NULL,
  tipo_tramite int(1) not null,
  PRIMARY KEY (id_suspension),
  KEY emp_sus_fk (dni_empleado),
  KEY usu_sus_fk (dni_usuario),
  KEY tra_sus_fk (tipo_tramite),
  CONSTRAINT emp_sus_fk FOREIGN KEY (dni_empleado) REFERENCES empleado (dni),
  CONSTRAINT usu_sus_fk FOREIGN KEY (dni_usuario) REFERENCES usuario (dni),
  CONSTRAINT tra_sus_fk FOREIGN KEY (tipo_tramite) REFERENCES tramites (id)
  );
  
   CREATE TABLE citas (
  codigo_cita varchar(6) not null,
  dni_usuario varchar(9) not null,
  fecha varchar (10) not null,
  hora varchar (8) not null,
  llamado bool not null,
  tipo_tramite int(1) not null,
  PRIMARY KEY (codigo_cita),
  KEY usu_sus_fk (dni_usuario),
  KEY tra_cit_fk (tipo_tramite),
  CONSTRAINT usu_cit_fk FOREIGN KEY (dni_usuario) REFERENCES usuario (dni),
  CONSTRAINT tra_cit_fk FOREIGN KEY (tipo_tramite) REFERENCES tramites (id)
  );
  
  
  CREATE TABLE historial (
  id_historial int (3) not null,
  cod_cita varchar(6) not null,
  dni_usuario varchar(9) not null,
  dni_empleado varchar (9) not null,
  fecha_cita varchar (10) not null,
  hora_cita varchar (8) not null,
  hora_finalizado varchar (8) not null,
  realizado bool not null,
  tipo_tramite int(1) not null,
  PRIMARY KEY (id_historial),
  key cit_his_fk (cod_cita),
  KEY usu_his_fk (dni_usuario),
  key emp_his_fk (dni_empleado),
  KEY tra_hist_fk (tipo_tramite),
  CONSTRAINT cit_his_fk FOREIGN KEY (cod_cita) REFERENCES citas (codigo_cita),
  CONSTRAINT usu_his_fk FOREIGN KEY (dni_usuario) REFERENCES usuario (dni),
  CONSTRAINT emp_his_fk FOREIGN KEY (dni_empleado) REFERENCES empleado (dni),
  CONSTRAINT tra_his_fk FOREIGN KEY (tipo_tramite) REFERENCES tramites (id)
  );
  
INSERT INTO usuario VALUES ('54632548l','Mar','Fito Rodrigez','fito','Calle Lago 3','ES151542235621662546', '03/05/1987'),('54632525h','Lorena','Perez Lopez','lore','Calle Rio 2','ES151542235621663333', '10/06/1988');
insert into tramites values (1, 'Altas'), (2, 'Bajas'), (3, 'Suspensiones'), (4, 'Supervision');
INSERT INTO empleado VALUES ('45632548l','Stephanie','Cuncun Trastras','fifi',4,4), ('45667958l','Manolo','Garcia Rincon','lolo',1,1), ('75987958l','Andres','Rodriguez Huertas','andi',2,2), ('65487958l','Rosa','Pez Lolailo','ros',3,3);