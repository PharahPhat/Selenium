package com.interop.services.dwh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interop.models.altevv.dwh.DwhExport;
import com.interop.services.base.RestfulService;
import org.apache.log4j.Logger;

public class DwhExportService extends RestfulService {

    private static final Logger LOGGER = Logger.getLogger(DwhExportService.class);
    private DwhExport model = new DwhExport();

    public DwhExport getModel() {
        return model;
    }

    public void setModel(DwhExport model) {
        this.model = model;
        loadPayload(this.getModel());
    }

    @Override
    public String getURI() {
        return "interfaces/internal/evv/dwh/export/provider/exportWithConfiguration";
    }

    public void loadPayload(DwhExport dwhBody) {
        Gson gson = new GsonBuilder().create();
        payload = gson.toJsonTree(dwhBody);
    }
}
