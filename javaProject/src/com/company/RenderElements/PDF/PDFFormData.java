package com.company.RenderElements.PDF;

import com.company.RenderElements.RenderElement;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * It is possible to fill in the forms using AOP. The data object inside the files array should contain
 * an object with the key aop_pdf_form_data.
 */
public class PDFFormData extends RenderElement {

    HashMap<String,String> formData = new HashMap<>();

    /**
     * @return Hashmap of the fieldname and value to fill in. Two options : inputfieldname : value and radio/checkbox : true/false.
     */
    public HashMap<String, String> getFormData() {
        return formData;
    }

    /**
     * @param formData Hashmap of the fieldname and value to fill in. Two options : inputfieldname : value and radio/checkbox : true/false.
     */
    public void setFormData(HashMap<String, String> formData) {
        this.formData = formData;
    }

    /**
     * It is possible to fill in the forms using AOP. The data object inside the files array should contain
     * an object with the key aop_pdf_form_data.
     * @param formData  Hashmap of the fieldname and value to fill in. Two options : inputfieldname : value and radio/checkbox : true/false.
     */
    PDFFormData(HashMap<String, String> formData){
        setName("AOP_PDF_IMAGES");
        setFormData(formData);
    }

    /**
     * @return JSONObject with the tags for this element for the AOP server.
     */
    @Override
    public JsonObject getJSON() {
        JsonObject json = new JsonObject();
        for (Map.Entry<String,String> entry : getFormData().entrySet()){
            json.addProperty(entry.getKey(),entry.getValue());
        }
        return json;
    }

    /**
     * @return  An immutable set containing all available template tags this element can replace.
     */
    @Override
    public Set<String> getTemplateTags() {
        Set<String> hash_Set = new HashSet<String>();
        return ImmutableSet.copyOf(hash_Set);
    }
}