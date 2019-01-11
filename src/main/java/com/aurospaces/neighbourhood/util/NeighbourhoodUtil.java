/**
 * 
 */
package com.aurospaces.neighbourhood.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.aurospaces.neighbourhood.db.model.Vendor1;
import com.aurospaces.neighbourhood.patent.GeoMain;
import com.aurospaces.neighbourhood.patent.GeoTag;

/**
 * @author Amit
 * 
 */
public class NeighbourhoodUtil {
	Logger objLogger = Logger.getLogger(NeighbourhoodUtil.class);

	public String getGUId() {
		String sUId = null;
		try {
			sUId = UUID.randomUUID().toString();
		} catch (Exception e) {
			objLogger.error("error in getGUId() in NeighbourhoodUtil");
		}
		return sUId;
	}

	public String getCurrentTimestamp(String sFormat) {
		String sCurrentTimestamp = null;
		Calendar objCal = null;
		DateFormat objDateFormate = null;
		String sDefaultFormat = "yyyy-MM-dd HH:mm:ss";
		try {
			if (sFormat == null || (sFormat != null && sFormat.length() == 0)) {
				sFormat = sDefaultFormat;
			}
			objDateFormate = new SimpleDateFormat(sFormat);
			objCal = Calendar.getInstance();
			sCurrentTimestamp = objDateFormate.format(objCal.getTime());
		} catch (Exception e) {
			objLogger.error("error in getCrrentTimestamp() in NeighbourhoodUtil");
			e.printStackTrace();
		} finally {

		}
		return sCurrentTimestamp;
	}

	public String getDate(int sScheduleDate) {
		String sDate = null;
		Calendar objCal = null;
		DateFormat objDateFormate = null;
		String sDefaultFormat = "yyyy-MM-dd HH:mm:ss";
		try {
			objCal = Calendar.getInstance();
			objCal.add(Calendar.DAY_OF_YEAR, sScheduleDate);
			objDateFormate = new SimpleDateFormat(sDefaultFormat);
			sDate = objDateFormate.format(objCal.getTime());
		} catch (Exception e) {
			objLogger.error("error in getDate() in NeighbourhoodUtil");
			e.printStackTrace();
		} finally {

		}
		return sDate;
	}

	private static final char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	public static String randomString(char[] characterSet, int length) {
		SecureRandom random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}

	public String randNum() {
		String randNum = randomString(CHARSET_AZ_09, 5);
		return randNum;

	}

	public String getSimpleDate(String dateToBeChanged) {
		SimpleDateFormat objDateFormat = null;
		String lDate = null;
		try {
			objDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			lDate = objDateFormat.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateToBeChanged));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return lDate;
	}

	public static BigDecimal getDiscount(String price, String discount) {
		BigDecimal finalDiscount = 	new BigDecimal(price).multiply(new BigDecimal(discount)).divide(new BigDecimal(100));
		return finalDiscount;
	}

	public static BigDecimal getDiscount(BigDecimal price, BigDecimal discountPrice) {
		BigDecimal finalDiscount = price.subtract(discountPrice);
		return finalDiscount;
	}

	public static BigDecimal getDiscountPrice(BigDecimal price, BigDecimal discount) {
		BigDecimal finalDiscount = (discount).multiply(price).divide(new BigDecimal(100));
		return finalDiscount;
	}

	public static BigDecimal totalDisc(BigDecimal totalNetAmt, BigDecimal totalPrice) {

		BigDecimal sub = (totalNetAmt != null && totalNetAmt.intValue() > 0)
				? totalPrice.divide(totalNetAmt).multiply(new BigDecimal(100)) : new BigDecimal(0);

		BigDecimal totalDiscount = new BigDecimal(100).subtract(sub);
		return totalDiscount;

	}

	public  static List<String>  insertImage(String path, String regUrl) {
		 File filePath = new File(path);
		 List<String> imageList = null;
		if (filePath.isDirectory()) { // make sure it's a directory
			 imageList = new ArrayList<String>();
			for (final File f : filePath.listFiles(IMAGE_FILTER)) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(f);
					//String imgUrl = baseUrl+File.separator+"nbdimages"+File.separator+"mobile"+File.separator+"package"+File.separator+"painter"+File.separator+f.getName();
					String imgUrl = regUrl+File.separator+f.getName();
					imageList.add(imgUrl);
					System.out.println("image: " + imgUrl);
					/*System.out.println(" width : " + img.getWidth());
					System.out.println(" height: " + img.getHeight());
					System.out.println(" size  : " + f.length());*/
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		return imageList;
	}

	// File representing the folder that you select using a FileChooser
	//static final File dir = new File("/home/yogi/Desktop/gladiator/src/main/webapp/nbdimages/mobile/package");

	// array of supported extensions (use a List if you prefer)
	static final String[] EXTENSIONS = new String[] { "jpg", "png", "bmp", "jpeg" // and
																					// other
																					// formats
																					// you
																					// need
	};

	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

	public double getLatLong(){
		GeoMain gm = new GeoMain();
		  GeoTag latlong =  gm.getAddr("Hsr Layout,Bangalore,Karnataka");
			return latlong.x;
	}
	public static void main(String k[]) {
		NeighbourhoodUtil objNeighbourhoodUtil = new NeighbourhoodUtil();
		System.out.println(objNeighbourhoodUtil.getLatLong());;
		/*if (dir.isDirectory()) { // make sure it's a directory
			for (final File f : dir.listFiles(IMAGE_FILTER)) {
				BufferedImage img = null;

				try {
					img = ImageIO.read(f);

					// you probably want something more involved here
					// to display in your UI
					System.out.println("image: " + f.getName());
					System.out.println(" width : " + img.getWidth());
					System.out.println(" height: " + img.getHeight());
					System.out.println(" size  : " + f.length());
				} catch (final IOException e) {
					// handle errors here
					e.printStackTrace();
				}
			}
		}*/

	}
}
