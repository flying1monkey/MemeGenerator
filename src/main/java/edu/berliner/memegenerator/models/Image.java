package edu.berliner.memegenerator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long imgId;

	private String imgName;

	private String imgUrl;

	public long getImgId()
	{
		return imgId;
	}

	public void setImgId(long imgId)
	{
		this.imgId = imgId;
	}

	public String getImgName()
	{
		return imgName;
	}

	public void setImgName(String name)
	{
		this.imgName = name;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}
}
