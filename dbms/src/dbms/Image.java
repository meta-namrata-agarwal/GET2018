package dbms;

import java.sql.Blob;

public class Image {

    private int imageId;
  
    private String blobImage;
    private int productId;
    public Image(int productId, int imageId, String  blobImage) {
        // TODO Auto-generated constructor stub
        this.imageId=imageId;
        this.productId=productId;
        this.blobImage=blobImage;
    }
    /**
     * @return the imageId
     */
    public int getImageId() {
        return imageId;
    }
    /**
     * @param imageId the imageId to set
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    /**
     * @return the blobImage
     */
    public String getBlobImage() {
        return blobImage;
    }
    /**
     * @param blobImage the blobImage to set
     */
    public void setBlobImage(String blobImage) {
        this.blobImage = blobImage;
    }
    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }
    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Image [getImageId()=" + getImageId() + ", getBlobImage()="
                + getBlobImage() + ", getProductId()=" + getProductId() + "]";
    }
   
   

}
