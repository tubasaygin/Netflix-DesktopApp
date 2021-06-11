import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Islemler {
    

    private static Connection con = null;
    public static Connection getConn() throws Exception {
    if(con == null){
    Class.forName("org.sqlite.JDBC");
    con = DriverManager.getConnection("jdbc:sqlite:DB/denemem.db");
    
    }
    return con;
    }

    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    private static String mail;
    Date simdikiZaman = new Date();
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    DateFormat fark=new SimpleDateFormat("hh:mm:ss");
    private static String süre;
    private static int [] dizi2= KayitOlSayfasi.getDizi();
    private static String [] dizi3= new String[6];
    private static int i=0;
    private static String programAdı, izlemeSure;
    private static int bolum;

    public static int getBolum() {
        return bolum;
    }

    public static void setBolum(int bolum) {
        Islemler.bolum = bolum;
    }
    
    public static String getProgramAdı() {
        return programAdı;
    }

    public static String getIzlemeSure() {
        return izlemeSure;
    }
    

    public static String[] getDizi3() {
        return dizi3;
    }

    public static void setDizi3(String[] dizi3) {
        Islemler.dizi3 = dizi3;
    }
    
    
    public static String getSüre() {
        return süre;
    }

    public static void setSüre(String süre) {
        Islemler.süre = süre;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        Islemler.mail = mail;
    }
    

    public void  izlemeSüreEkle(long beginTime, long endTime){
       
        long saat = (((long) (endTime - beginTime)) / 1000);
        saat = saat/3600;
        long dakika =(((long) (endTime - beginTime)) / 1000); 
        dakika=dakika/60;
        long saniye=(((long) (endTime - beginTime)) / 1000)%60;  
        süre = saat+":"+dakika+":"+saniye;
        
    }
    
  
   
    public void emailekle(String mail,String süre,String Ad,String puan, int Hangi,String Tip){
        
  
        String sorgu2 = "INSERT INTO kullanıcıprogram (EMAIL,HangiProgram,Tip,HangiBolum, puan,İzlemeTarihi,İzlemeSüresi) VALUES (?,?,?,?,?,?,?)";    
        try {
      
            preparedStatement = con.prepareStatement(sorgu2);
           
            preparedStatement.setString(1,mail);
            preparedStatement.setString(2,Ad);
            preparedStatement.setString(3,Tip);

            preparedStatement.setInt(4,Hangi);
            preparedStatement.setString(5,puan);
            preparedStatement.setString(6,df.format(simdikiZaman));
            preparedStatement.setString(7,süre);
            

            preparedStatement.executeUpdate();
        
            
       
           
                   
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    

    public ArrayList<Programlar> filmleriGetir(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk From programtablosu";
          
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                //int ProgramID = rs.getInt("ProgramID");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
                


            }
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir3(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=1 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir2(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=3 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
               

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir4(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=11 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir5(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=14 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir6(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=7 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir7(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=13 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir8(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=10 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public ArrayList<Programlar> filmleriGetir9(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=5 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir10(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=8 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir11(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=4 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir12(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=6 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir13(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=2 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir14(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=12 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
   public ArrayList<Programlar> filmleriGetir15(){
        ArrayList <Programlar> cikti = new ArrayList<Programlar>();
        
        try {
            statement = con.createStatement();
            String sorgu= "Select ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=9 AND programtur.ProgramID=programtablosu.ProgramID";
            
            
            ResultSet rs = statement.executeQuery(sorgu);
        
            while(rs.next()){
                String ProgramAdı = rs.getString("ProgramAdı");
                String ProgramTipi = rs.getString("ProgramTipi");
                int kacBolum = rs.getInt("kacBolum");
                String time  = rs.getString("ProgramUzunluk");
                
                cikti.add(new Programlar(ProgramAdı, ProgramTipi, kacBolum, time));
          

            }
            
            
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
  public void kayitOlustur(String Ad, String email, String sifre, int DogumYili,String türler){
          String sorgu = "Insert Into kullanıcı(Ad, email, Sifre, DogumTarihi,İzledigiTur) VALUES(?,?,?,?,?)";
          try {
              preparedStatement = con.prepareStatement(sorgu);

              preparedStatement.setString(1,Ad);
              preparedStatement.setString(2,email);
              preparedStatement.setString(3,sifre);
              preparedStatement.setInt(4,DogumYili);
              preparedStatement.setString(5,türler);


              preparedStatement.executeUpdate();
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          
          }

      }      
  public boolean varMı(String email){
     
          String sorgu = "Select * from kullanıcı where email=?";
           ResultSet rs=null;
          try {
              
              preparedStatement = con.prepareStatement(sorgu);
              
             
              preparedStatement.setString(1,email);
            
              
              
              rs = preparedStatement.executeQuery();
              
              return rs.next();
             
              
          }
          catch(SQLException ex){
              Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE,null,ex);
              return false;
              
              

              
          }
          finally {
        if(rs != null){
             try{
                  rs.close();
             } catch(Exception e){
                 e.printStackTrace();
             }
        }
        if(preparedStatement != null){
            try{
                preparedStatement.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

      }
    public void oneriyiGetir(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=1 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                
                dizi3[i]=ProgramAdı;
                     
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir2(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=2 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                
                dizi3[i]=ProgramAdı;
                     
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir3(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=3 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir4(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=4 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir5(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=5 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
                           

            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir6(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=6 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir7(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=7 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;

                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir8(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=8 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;

                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir9(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=9 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;

                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir10(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=10 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir11(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=11 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
                           

            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir12(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=12 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir13(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=13 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void oneriyiGetir14(){
        try {
            statement =  con.createStatement();
            String sorgu=  "Select  ProgramAdı, ProgramTipi, KacBolum, ProgramUzunluk from programtablosu,programtur,türler where türler.türid=programtur.türid AND türler.türid=14 AND programtur.ProgramID=programtablosu.ProgramID ORDER BY IMDB DESC LIMIT 2";
            ResultSet rs= statement.executeQuery(sorgu);
            while(rs.next()){
                String ProgramAdı=rs.getString("ProgramAdı");
                
                dizi3[i]=ProgramAdı;
                i++;
            }
             } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
   public  String kaldiginFilmiGoster(String email2){
         String Tip1 = "";
       try {
           statement = con.createStatement();
            String sorgu = "Select HangiProgram,HangiBolum, İzlemeSüresi, Tip from kullanıcıprogram where EMAIL='"+email2+"' order by İzlemeTarihi desc LIMIT 1";
       
               
              ResultSet rs = statement.executeQuery(sorgu);
             
            while(rs.next()){
                String Hangi = rs.getString("HangiProgram");
                String süre= rs.getString("İzlemeSüresi");
             Tip1=rs.getString("Tip");
                programAdı=Hangi;
                izlemeSure=süre;
                bolum=rs.getInt("HangiBolum");
               
            } 
            return Tip1;
          
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         return null;
        }
        
        
   }

    
    public Islemler(){
          String url="jdbc:sqlite:DB/denemem.db";
          String driver="org.sqlite.JDBC";
          try {
        Class.forName(driver).newInstance();
        con=DriverManager.getConnection(url);
             System.out.println("Veritabanı baglantisi basarili");
    } catch (Exception ex) {
              System.out.println("Veritabanı baglantisi basarisiz");
    }
          
      
    }    
          
    

    public static void main(String[] args) {
        Islemler islem= new Islemler();
       
    }
}
