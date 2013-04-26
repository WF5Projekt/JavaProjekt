package sonstiges;

import javax.swing.JOptionPane;

public class MD5 {
	//Static Methode um eine MD5 verschl�sselung zu erm�glichen.
	
	public static String MD5(String md5) {  
		try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    	JOptionPane.showInputDialog(null, "MD5 Fehler");
		    }
		    return null;
		}
}
