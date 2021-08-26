package com.cloudofficeprint;

/**
 * Own mimetype class (org.apache.tike gives warnings for logging)
 */
public class Mimetype {

    /**
     * Return the mimetype given the extension of a file.
     * 
     * @param extension Extension of the file to find the mimetype.
     * @return Mimetype of the file.
     * @throws Exception If the file type is not supported (cannot find the
     *                   mimetype).
     */
    public static String getMimeType(String extension) throws Exception {
        if (extension.startsWith(".")) {
            extension = extension.substring(1);
        }
        if (extension.equals("bmp")) {
            return "image/bmp";
        }
        if (extension.equals("csv")) {
            return "text/csv";
        }
        if (extension.equals("docx")) {
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }
        if (extension.equals("doc")) {
            return "application/msword";
        }
        if (extension.equals("docm")) {
            return "application/vnd.ms-word.document.macroEnabled.12";
        }
        if (extension.equals("gif")) {
            return "image/gif";
        }
        if (extension.equals("html")) {
            return "text/html";
        }
        if (extension.equals("ics")) {
            return "text/calendar";
        }
        if (extension.equals("ifb")) {
            return "text/calendar";
        }
        if (extension.equals("xml")) {
            return "application/xml";
        }
        if (extension.equals("jpeg")) {
            return "image/jpeg";
        }
        if (extension.equals("md")) {
            return "text/markdown";
        }
        if (extension.equals("msbmp")) {
            return "image/x-ms-bmp";
        }
        if (extension.equals("onepagepdf")) {
            return "application/pdf";
        }
        if (extension.equals("pdf")) {
            return "application/pdf";
        }
        if (extension.equals("png")) {
            return "image/png";
        }
        if (extension.equals("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (extension.equals("pptx")) {
            return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        }
        if (extension.equals("pptm")) {
            return "application/vnd.ms-powerpoint.presentation.macroEnabled.12";
        }
        if (extension.equals("rtf")) {
            return "application/rtf";
        }
        if (extension.equals("svg")) {
            return "image/svg+xml";
        }
        if (extension.equals("txt")) {
            return "text/plain";
        }
        if (extension.equals("count_tags")) {
            return "text/plain";
        }
        if (extension.equals("count_tags")) {
            return "text/plain";
        }
        if (extension.equals("form_fields")) {
            return "text/plain";
        }
        if (extension.equals("meta_data")) {
            return "text/plain";
        }
        if (extension.equals("webp")) {
            return "image/webp";
        }
        if (extension.equals("xls")) {
            return "application/vnd.ms-excel";
        }
        if (extension.equals("xlsx")) {
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        if (extension.equals("xlsm")) {
            return "application/vnd.ms-excel.sheet.macroEnabled.12";
        }
        if (extension.equals("zip")) {
            return "application/zip";
        }
        if (extension.equals("odt")) {
            return "application/vnd.oasis.opendocument.text";
        }
        if (extension.equals("ods")) {
            return "application/vnd.oasis.opendocument.spreadsheet";
        }
        if (extension.equals("odp")) {
            return "application/vnd.oasis.opendocument.presentation";
        }
        if (extension.equals("pdf.pdf")) {
            return "application/pdf";
        } else
            throw new Exception("File type not supported, so cannot find the mimetype");
    }
    
    /**
     * Return the extension given the mimetype of a file.
     * 
     * @param mimetype Mimetype of the file to find the extension.
     * @return Extension of the file.
     * @throws Exception If the mimetype is not supported (cannot find the
     *                   extension).
     */
    public static String getExtension(String mimetype) throws Exception {
        if (mimetype.startsWith(".")) {
            mimetype = mimetype.substring(1);
        }
        if (mimetype.equals("image/bmp")) {
            return "bmp";
        }
        if (mimetype.equals("text/csv")) {
            return "csv";
        }
        if (mimetype.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            return "docx";
        }
        if (mimetype.equals("application/msword")) {
            return "doc";
        }
        if (mimetype.equals("application/vnd.ms-word.document.macroEnabled.12")) {
            return "docm";
        }
        if (mimetype.equals("image/gif")) {
            return "gif";
        }
        if (mimetype.equals("text/html")) {
            return "html";
        }
        if (mimetype.equals("text/calendar")) {
            return "ics";
        }
        if (mimetype.equals("application/xml")) {
            return "xml";
        }
        if (mimetype.equals("image/jpeg")) {
            return "jpeg";
        }
        if (mimetype.equals("text/markdown")) {
            return "md";
        }
        if (mimetype.equals("image/x-ms-bmp")) {
            return "msbmp";
        }
        if (mimetype.equals("application/pdf")) {
            return "pdf";
        }
        if (mimetype.equals("image/png")) {
            return "png";
        }
        if (mimetype.equals("application/vnd.ms-powerpoint")) {
            return "ppt";
        }
        if (mimetype.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
            return "pptx";
        }
        if (mimetype.equals("application/vnd.ms-powerpoint.presentation.macroEnabled.12")) {
            return "pptm";
        }
        if (mimetype.equals("application/rtf")) {
            return "rtf";
        }
        if (mimetype.equals("image/svg+xml")) {
            return "svg";
        }
        if (mimetype.equals("text/plain")) {
            return "txt";
        }
        if (mimetype.equals("image/webp")) {
            return "webp";
        }
        if (mimetype.equals("application/vnd.ms-excel")) {
            return "xls";
        }
        if (mimetype.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return "xlsx";
        }
        if (mimetype.equals("application/vnd.ms-excel.sheet.macroEnabled.12")) {
            return "xlsm";
        }
        if (mimetype.equals("application/zip")) {
            return "zip";
        }
        if (mimetype.equals("application/vnd.oasis.opendocument.text")) {
            return "odt";
        }
        if (mimetype.equals("application/vnd.oasis.opendocument.spreadsheet")) {
            return "ods";
        }
        if (mimetype.equals("application/vnd.oasis.opendocument.presentation")) {
            return "odp";
        } else
            throw new Exception("Mime type not supported, so cannot find the mimetype");
    }

    /**
     * Extract the mimetype from the Content-Type argument in an HTTP reponse.
     * @param contentType The Content-Type argument in an HTTP response
     * @return the mimetype in the Content-Type argument
     */
    public static String getMimetypeFromContentType(String contentType) {
        if (contentType.contains(";")) {
            int ind = contentType.indexOf(";");
            return contentType.substring(0, ind);
        } else {
            return contentType;
        }
    }
}
