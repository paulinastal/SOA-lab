
package pl.edu.agh.soa.lab1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addStudentAvatarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addStudentAvatarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="newAvatar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addStudentAvatarResponse", propOrder = {
    "newAvatar"
})
public class AddStudentAvatarResponse {

    protected String newAvatar;

    /**
     * Gets the value of the newAvatar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewAvatar() {
        return newAvatar;
    }

    /**
     * Sets the value of the newAvatar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewAvatar(String value) {
        this.newAvatar = value;
    }

}
