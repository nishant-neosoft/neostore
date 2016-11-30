
package com.neosoft.neostore.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("profile_pic")
    @Expose
    private Object profilePic;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("phone_no")
    @Expose
    private String phoneNo;
    @SerializedName("dob")
    @Expose
    private Object dob;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("access_token")
    @Expose
    private String accessToken;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * @param roleId
     *     The role_id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The profilePic
     */
    public Object getProfilePic() {
        return profilePic;
    }

    /**
     * 
     * @param profilePic
     *     The profile_pic
     */
    public void setProfilePic(Object profilePic) {
        this.profilePic = profilePic;
    }

    /**
     * 
     * @return
     *     The countryId
     */
    public Object getCountryId() {
        return countryId;
    }

    /**
     * 
     * @param countryId
     *     The country_id
     */
    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 
     * @param phoneNo
     *     The phone_no
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 
     * @return
     *     The dob
     */
    public Object getDob() {
        return dob;
    }

    /**
     * 
     * @param dob
     *     The dob
     */
    public void setDob(Object dob) {
        this.dob = dob;
    }

    /**
     * 
     * @return
     *     The isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 
     * @param isActive
     *     The is_active
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * 
     * @param modified
     *     The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 
     * @return
     *     The accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 
     * @param accessToken
     *     The access_token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
