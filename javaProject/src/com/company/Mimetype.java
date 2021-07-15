package com.company;

public class Mimetype {


    /**
     * As the tika library gives two warnings I decided to implement if manually for all the supported document formats (not a lot). I didn't find any better option for the moment.
     * @param extension Extension of the file to find the mimetype.
     * @return Mimetype of the file.
     * @throws Exception If the file type is not supported (cannot find the mimetype).
     */
    public static String getMimeType(String extension) throws Exception {
        if (extension.equals("bmp")){
            return "image/bmp";
        }
        if (extension.equals("csv")){
            return "text/csv";
        }
        if (extension.equals("docx")){
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }
        if (extension.equals("doc")){
            return "application/msword";
        }
        if (extension.equals("docm")){
            return "application/vnd.ms-word.document.macroEnabled.12";
        }
        if (extension.equals("gif")){
            return "image/gif";
        }
        if (extension.equals("html")){
            return "text/html";
        }
        if (extension.equals("ics")){
            return "text/calendar";
        }
        if (extension.equals("ifb")){
            return "text/calendar";
        }
        if (extension.equals("xml")){
            return "application/xml";
        }
        if (extension.equals("docm")){
            return "application/vnd.ms-word.document.macroEnabled.12";
        }
        if (extension.equals("jpeg")){
            return "image/jpeg";
        }
        if (extension.equals("md")){
            return "text/markdown";
        }
        if (extension.equals("msbmp")){
            return "image/x-ms-bmp";
        }
        if (extension.equals("onepagepdf")){
            return "application/pdf";
        }
        if (extension.equals("pdf")){
            return "application/pdf";
        }
        if (extension.equals("png")){
            return "image/png";
        }
        if (extension.equals("ppt")){
            return "application/vnd.ms-powerpoint";
        }
        if (extension.equals("pptx")){
            return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        }
        if (extension.equals("pptm")){
            return "application/vnd.ms-powerpoint.presentation.macroEnabled.12";
        }
        if (extension.equals("rtf")){
            return "application/rtf";
        }
        if (extension.equals("svg")){
            return "image/svg+xml";
        }
        if (extension.equals("txt")){
            return "text/plain";
        }
        if (extension.equals("count_tags")){
            return "text/plain";
        }
        if (extension.equals("count_tags")){
            return "text/plain";
        }
        if (extension.equals("form_fields")){
            return "text/plain";
        }
        if (extension.equals("meta_data")){
            return "text/plain";
        }
        if (extension.equals("webp")){
            return "image/webp";
        }
        if (extension.equals("xls")){
            return "application/vnd.ms-excel";
        }
        if (extension.equals("xlsx")){
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        if (extension.equals("xlsm")){
            return "application/vnd.ms-excel.sheet.macroEnabled.12";
        }
        if (extension.equals("zip")){
            return "application/zip";
        }
        if (extension.equals("odt")){
            return "application/vnd.oasis.opendocument.text";
        }
        if (extension.equals("ods")){
            return "application/vnd.oasis.opendocument.spreadsheet";
        }
        if (extension.equals("odp")){
            return "application/vnd.oasis.opendocument.presentation";
        }
        if (extension.equals("odt")){
            return "application/vnd.oasis.opendocument.text";
        }
        if (extension.equals("pdf.pdf")){
            return "application/pdf";
        }
        else throw new Exception("File type not supported, so cannot find the mimetype");
    }
}
