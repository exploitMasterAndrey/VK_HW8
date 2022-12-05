/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Factory;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FactoryRecord extends UpdatableRecordImpl<FactoryRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.factory.name</code>.
     */
    public FactoryRecord setName(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.factory.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.factory.address</code>.
     */
    public FactoryRecord setAddress(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.factory.address</code>.
     */
    public String getAddress() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Factory.FACTORY.NAME;
    }

    @Override
    public Field<String> field2() {
        return Factory.FACTORY.ADDRESS;
    }

    @Override
    public String component1() {
        return getName();
    }

    @Override
    public String component2() {
        return getAddress();
    }

    @Override
    public String value1() {
        return getName();
    }

    @Override
    public String value2() {
        return getAddress();
    }

    @Override
    public FactoryRecord value1(String value) {
        setName(value);
        return this;
    }

    @Override
    public FactoryRecord value2(String value) {
        setAddress(value);
        return this;
    }

    @Override
    public FactoryRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FactoryRecord
     */
    public FactoryRecord() {
        super(Factory.FACTORY);
    }

    /**
     * Create a detached, initialised FactoryRecord
     */
    public FactoryRecord(String name, String address) {
        super(Factory.FACTORY);

        setName(name);
        setAddress(address);
    }

    /**
     * Create a detached, initialised FactoryRecord
     */
    public FactoryRecord(generated.tables.pojos.Factory value) {
        super(Factory.FACTORY);

        if (value != null) {
            setName(value.getName());
            setAddress(value.getAddress());
        }
    }
}
