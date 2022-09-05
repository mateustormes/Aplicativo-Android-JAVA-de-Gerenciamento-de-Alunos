package com.novamerica.safetouractivity.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 5;

    public Conexao(Context context){
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){

            db.execSQL("DROP TABLE USUARIO");
            db.execSQL("CREATE TABLE IF NOT EXISTS USUARIO(id integer primary key autoincrement," +
                    "matricula integer, nome varchar(50), email varchar(80), senha varchar(40), cpf varchar(50), telefone varchar(50), integrado varchar(1))");

            db.execSQL("DROP TABLE FORMULARIO");
            db.execSQL("CREATE TABLE IF NOT EXISTS FORMULARIO(id integer primary key autoincrement," +
                    "descricao varchar(100), integrado varchar(1))");

            db.execSQL("DROP TABLE TOPICOS_PERGUNTAS");
            db.execSQL("CREATE TABLE IF NOT EXISTS TOPICOS_PERGUNTAS(id integer primary key autoincrement," +
                    "descricao varchar(100), integrado varchar(1))");

            db.execSQL("DROP TABLE PERGUNTAS");
            db.execSQL("CREATE TABLE IF NOT EXISTS PERGUNTAS(id integer primary key autoincrement," +
                    "formulario_id integer, topicos_perguntas_id integer, descricao_pergunta varchar(200),"+
                    "status varchar(1), pergunta_dinamica varchar(1), integrado varchar(1))");

            db.execSQL("DROP TABLE PERGUNTAS_DINAMICAS");
            db.execSQL("CREATE TABLE IF NOT EXISTS PERGUNTAS_DINAMICAS(id integer primary key autoincrement," +
                    "pergunta_id integer, nome_pergunta varchar(200),"+
                    "resposta_pergunta varchar(200), integrado varchar(1), latitude varchar(50), longitude varchar(50))");

            db.execSQL("DROP TABLE TIPO_RESPOSTAS");
            db.execSQL("CREATE TABLE IF NOT EXISTS TIPO_RESPOSTAS(id integer primary key autoincrement," +
                    "conceito varchar(100), situacao varchar(50), nota integer, status varchar(1), integrado varchar(1))");

            db.execSQL("DROP TABLE RESPOSTAS");
            db.execSQL("CREATE TABLE IF NOT EXISTS RESPOSTAS(usuario_id integer," +
                    "formulario_id integer, tipo_respostas_id integer, "+
                    "pergunta_id integer, integrado varchar(1), latitude varchar(50), longitude varchar(50)" +
                    ",PRIMARY KEY(usuario_id, formulario_id, tipo_respostas_id, pergunta_id))");

            db.execSQL("DROP TABLE PLANO_ACAO");
            db.execSQL("CREATE TABLE IF NOT EXISTS PLANO_ACAO(usuario_id integer," +
                    "formulario_id integer, pergunta_id integer, resposta_id integer,"+
                    "tipo_plano_id integer, descricao varchar(200), integrado varchar(1), responsavel integer,"+
                    "prazo DATE, latitude varchar(50), longitude varchar(50)" +
                    ",PRIMARY KEY(usuario_id, formulario_id, pergunta_id, resposta_id, tipo_plano_id))");

            db.execSQL("DROP TABLE TIPO_PLANO_ACAO");
            db.execSQL("CREATE TABLE IF NOT EXISTS TIPO_PLANO_ACAO(id integer primary key autoincrement," +
                    "descricao varchar(100), integrado varchar(1))");

            db.execSQL("DROP TABLE USUARIO_FORMULARIO");
            db.execSQL("CREATE TABLE IF NOT EXISTS USUARIO_FORMULARIO(formulario_id integer ," +
                    "usuario_id integer , entrevistado_id integer , lider_id integer "+
                    ", dataLimite Date, respondido varchar(1), pontuacao_geral integer, integrado varchar(1), area_entrevistado varchar(100),"+
                    "turno varchar(100), horaInicio Date, horaFim Date, latitude varchar(50), longitude varchar(50)" +
                    ",PRIMARY KEY(formulario_id, usuario_id, entrevistado_id, lider_id))");
        }
    }

}
