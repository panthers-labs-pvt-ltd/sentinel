package com.progressive.minds.chimera.sentinel.datahub.search;

/*import com.progressive.minds.chimera.core.databaseOps.model.datahub.MetadataAspectV2;
import com.progressive.minds.chimera.core.databaseOps.repository.datahub.MetadataAspectV2Repository;*/

import java.util.HashMap;
import java.util.Map;

public class searchAssets {
    public static boolean get(String Urn, String aspect) {
        System.setProperty("CHIMERA_EXE_ENV", "datahub");
        Map<String, Object> filters = new HashMap<>();
        filters.put("urn", Urn);
        filters.put("aspect", aspect);

        //TODO  - fix need to be done here- Module is databaseops module is removed
        /* List<MetadataAspectV2> returnVal = MetadataAspectV2Repository.getConfig(filters);*/
        //  System.out.println(returnVal.size());
        return true;
      /*  if (returnVal.size() >0)
            return true;
        else
            return false;*/
    }
}
