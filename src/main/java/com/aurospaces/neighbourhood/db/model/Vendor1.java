package com.aurospaces.neighbourhood.db.model;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

import com.aurospaces.neighbourhood.db.basemodel.BaseVendor1;


@Entity (name = "Vendor1")
public class Vendor1 extends BaseVendor1
{
	public MultipartFile portfolio;
	public MultipartFile videos;
	public MultipartFile moufiles;
	public MultipartFile commercialsfiles;
	public MultipartFile image;
	public String dateOfBirthh;
	public String serviceName;
	public String packageName;
	public String locationName;
	
	

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public MultipartFile getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(MultipartFile portfolio) {
		this.portfolio = portfolio;
	}

	public MultipartFile getVideos() {
		return videos;
	}

	public void setVideos(MultipartFile videos) {
		this.videos = videos;
	}

	public MultipartFile getMoufiles() {
		return moufiles;
	}

	public void setMoufiles(MultipartFile moufiles) {
		this.moufiles = moufiles;
	}

	public MultipartFile getCommercialsfiles() {
		return commercialsfiles;
	}

	public void setCommercialsfiles(MultipartFile commercialsfiles) {
		this.commercialsfiles = commercialsfiles;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getDateOfBirthh() {
		return dateOfBirthh;
	}

	public void setDateOfBirthh(String dateOfBirthh) {
		this.dateOfBirthh = dateOfBirthh;
	}

	
}
