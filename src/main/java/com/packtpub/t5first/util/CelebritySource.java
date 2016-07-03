package com.packtpub.t5first.util;

import com.packtpub.t5first.data.IDataSource;
import com.packtpub.t5first.model.Celebrity;
import org.apache.tapestry5.beaneditor.PropertyModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalantaev Alexandr on 24.06.2016.
 */
public class CelebritySource implements GridDataSource {
    private IDataSource dataSource;
    private List<Celebrity> selection;
    private int indexFrom;

    public CelebritySource(IDataSource ds) {
        this.dataSource = ds;
    }

    public int getAvailableRows() {
        return dataSource.getAllCelebrities().size();
    }

    @Override
    public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
        System.out.println("Preparing selection.");
        System.out.println("Index from " + startIndex + " to " + endIndex);
        System.out.println(sortConstraints.get(0).getColumnSort());
        System.out.println(sortConstraints.get(0).getPropertyModel().getPropertyName());
        selection = dataSource.getRange(startIndex, endIndex);
        this.indexFrom = startIndex;
    }




    public void prepare(int indexFrom, int indexTo,
                        PropertyModel propertyModel, boolean ascending) {

        String propertyName = propertyModel == null ? null : propertyModel.getPropertyName();

        selection = dataSource.getRange(indexFrom, indexTo);
        this.indexFrom = indexFrom;
    }

    public Object getRowValue(int i) {
        System.out.println("Getting value for row " + i);
        return selection.get(i - this.indexFrom);
    }

    public Class getRowType() {
        return Celebrity.class;
    }
}
