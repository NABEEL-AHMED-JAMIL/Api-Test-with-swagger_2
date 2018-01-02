package com.example.demo.service.fetchservice;

/**
 * Created by Nabeel on 10/17/2017.
 */
public class FileFetchService {

    private static FileFetchService fileFetchService;

    private FileFetchService(){}

    public static FileFetchService getObject(){
        if(fileFetchService == null){
            fileFetchService = new FileFetchService();
        }
        return fileFetchService;
    }


    public String getFileType (String type) {
        // this
        switch (type) {

            case "md":
                break;
            case "txt":
                break;
            case "csv":
                break;
            default:
                break;
        }

        return null;
    }

}
