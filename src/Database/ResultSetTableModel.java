package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;



/**
 *
 * 
 * @author aove
 * 
 * 
 */
public class ResultSetTableModel extends AbstractTableModel {

    
    
private Connection conexion;
private Statement instruccion;
private ResultSet conjuntoResultados;
private ResultSetMetaData metaDatos;
private int numeroDeFilas;


private String user;
private String pass;
private String url;

private boolean conectadoABaseDatos = false;

    public ResultSetTableModel( String controlador,String url, String nombreusuario, String contrasenia, String consulta ) throws SQLException, ClassNotFoundException
    
    {
        Class.forName( controlador );
        conexion = DriverManager.getConnection( url, nombreusuario, contrasenia );
        instruccion = conexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY );
        conectadoABaseDatos = true;
        establecerConsulta( consulta );
    } 
    
    
    public Class getColumnClass( int columna ) throws IllegalStateException
    {

        if ( !conectadoABaseDatos )
            throw new IllegalStateException( "No hay conexion a la base de datos" );
            try
            {
                String nombreClase = metaDatos.getColumnClassName( columna + 1 );

                return Class.forName( nombreClase );
            } 
                catch ( Exception excepcion )
                {
                    excepcion.printStackTrace();
                } 
        return Object.class;
    } 
    public int getColumnCount() throws IllegalStateException
    {

        if ( !conectadoABaseDatos )
            throw new IllegalStateException( "No hay conexión a la base de datos" );

        try
        {
            return metaDatos.getColumnCount();
        } 
        catch ( SQLException excepcionSql )
        {
            excepcionSql.printStackTrace();
        } 
        return 0;
    } 
    
    public String getColumnName( int columna ) throws IllegalStateException
    {

        if ( !conectadoABaseDatos )
            throw new IllegalStateException( "No hay conexion a la base de datos" );
        try
        {
            return metaDatos.getColumnName( columna + 1 );
        } 
        catch ( SQLException excepcionSql )
        {
            excepcionSql.printStackTrace();
        } 
        return ""; 
    } 
    
    public int getRowCount() throws IllegalStateException
    {

        if ( !conectadoABaseDatos )
            throw new IllegalStateException( "No hay conexion a la base de datos" );
        return numeroDeFilas;
    } 
    
    public Object getValueAt( int fila, int columna ) throws IllegalStateException
    {
    
    if ( !conectadoABaseDatos )
    throw new IllegalStateException( "No hay conexion a la base de datos" );
    
    try
    {
        conjuntoResultados.absolute( fila + 1 );
        return conjuntoResultados.getObject( columna + 1 );
    } 
        catch ( SQLException excepcionSql )
    {
    excepcionSql.printStackTrace();
    }
    return ""; 
    } 
    
    public void establecerConsulta( String consulta ) throws SQLException, IllegalStateException
    {

        if ( !conectadoABaseDatos )throw new IllegalStateException( "No hay conexion a la base de datos" );

            conjuntoResultados = instruccion.executeQuery( consulta );

            metaDatos = conjuntoResultados.getMetaData();

            conjuntoResultados.last(); 
            numeroDeFilas = conjuntoResultados.getRow(); 

        fireTableStructureChanged();
    }
    
    public void desconectarDeBaseDatos()
    {
        if ( conectadoABaseDatos )
        {

            try
            {
                conjuntoResultados.close();
                instruccion.close();
                conexion.close();
            } 
            catch ( SQLException excepcionSql )
            {
                excepcionSql.printStackTrace();
            } 
            finally 
            {
                conectadoABaseDatos = false;
            } 
        } 
    } 
}

    

    

