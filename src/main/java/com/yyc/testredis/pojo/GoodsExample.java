package com.yyc.testredis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGStockIsNull() {
            addCriterion("g_stock is null");
            return (Criteria) this;
        }

        public Criteria andGStockIsNotNull() {
            addCriterion("g_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGStockEqualTo(Integer value) {
            addCriterion("g_stock =", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockNotEqualTo(Integer value) {
            addCriterion("g_stock <>", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockGreaterThan(Integer value) {
            addCriterion("g_stock >", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_stock >=", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockLessThan(Integer value) {
            addCriterion("g_stock <", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockLessThanOrEqualTo(Integer value) {
            addCriterion("g_stock <=", value, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockIn(List<Integer> values) {
            addCriterion("g_stock in", values, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockNotIn(List<Integer> values) {
            addCriterion("g_stock not in", values, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockBetween(Integer value1, Integer value2) {
            addCriterion("g_stock between", value1, value2, "gStock");
            return (Criteria) this;
        }

        public Criteria andGStockNotBetween(Integer value1, Integer value2) {
            addCriterion("g_stock not between", value1, value2, "gStock");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeIsNull() {
            addCriterion("g_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeIsNotNull() {
            addCriterion("g_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeEqualTo(Integer value) {
            addCriterion("g_sales_volume =", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeNotEqualTo(Integer value) {
            addCriterion("g_sales_volume <>", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeGreaterThan(Integer value) {
            addCriterion("g_sales_volume >", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_sales_volume >=", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeLessThan(Integer value) {
            addCriterion("g_sales_volume <", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("g_sales_volume <=", value, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeIn(List<Integer> values) {
            addCriterion("g_sales_volume in", values, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeNotIn(List<Integer> values) {
            addCriterion("g_sales_volume not in", values, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("g_sales_volume between", value1, value2, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("g_sales_volume not between", value1, value2, "gSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGLocationIdIsNull() {
            addCriterion("g_location_id is null");
            return (Criteria) this;
        }

        public Criteria andGLocationIdIsNotNull() {
            addCriterion("g_location_id is not null");
            return (Criteria) this;
        }

        public Criteria andGLocationIdEqualTo(String value) {
            addCriterion("g_location_id =", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdNotEqualTo(String value) {
            addCriterion("g_location_id <>", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdGreaterThan(String value) {
            addCriterion("g_location_id >", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdGreaterThanOrEqualTo(String value) {
            addCriterion("g_location_id >=", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdLessThan(String value) {
            addCriterion("g_location_id <", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdLessThanOrEqualTo(String value) {
            addCriterion("g_location_id <=", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdLike(String value) {
            addCriterion("g_location_id like", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdNotLike(String value) {
            addCriterion("g_location_id not like", value, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdIn(List<String> values) {
            addCriterion("g_location_id in", values, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdNotIn(List<String> values) {
            addCriterion("g_location_id not in", values, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdBetween(String value1, String value2) {
            addCriterion("g_location_id between", value1, value2, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGLocationIdNotBetween(String value1, String value2) {
            addCriterion("g_location_id not between", value1, value2, "gLocationId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdIsNull() {
            addCriterion("g_classfy_id is null");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdIsNotNull() {
            addCriterion("g_classfy_id is not null");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdEqualTo(String value) {
            addCriterion("g_classfy_id =", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdNotEqualTo(String value) {
            addCriterion("g_classfy_id <>", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdGreaterThan(String value) {
            addCriterion("g_classfy_id >", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdGreaterThanOrEqualTo(String value) {
            addCriterion("g_classfy_id >=", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdLessThan(String value) {
            addCriterion("g_classfy_id <", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdLessThanOrEqualTo(String value) {
            addCriterion("g_classfy_id <=", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdLike(String value) {
            addCriterion("g_classfy_id like", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdNotLike(String value) {
            addCriterion("g_classfy_id not like", value, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdIn(List<String> values) {
            addCriterion("g_classfy_id in", values, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdNotIn(List<String> values) {
            addCriterion("g_classfy_id not in", values, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdBetween(String value1, String value2) {
            addCriterion("g_classfy_id between", value1, value2, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGClassfyIdNotBetween(String value1, String value2) {
            addCriterion("g_classfy_id not between", value1, value2, "gClassfyId");
            return (Criteria) this;
        }

        public Criteria andGImgPathIsNull() {
            addCriterion("g_img_path is null");
            return (Criteria) this;
        }

        public Criteria andGImgPathIsNotNull() {
            addCriterion("g_img_path is not null");
            return (Criteria) this;
        }

        public Criteria andGImgPathEqualTo(String value) {
            addCriterion("g_img_path =", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathNotEqualTo(String value) {
            addCriterion("g_img_path <>", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathGreaterThan(String value) {
            addCriterion("g_img_path >", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("g_img_path >=", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathLessThan(String value) {
            addCriterion("g_img_path <", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathLessThanOrEqualTo(String value) {
            addCriterion("g_img_path <=", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathLike(String value) {
            addCriterion("g_img_path like", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathNotLike(String value) {
            addCriterion("g_img_path not like", value, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathIn(List<String> values) {
            addCriterion("g_img_path in", values, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathNotIn(List<String> values) {
            addCriterion("g_img_path not in", values, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathBetween(String value1, String value2) {
            addCriterion("g_img_path between", value1, value2, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andGImgPathNotBetween(String value1, String value2) {
            addCriterion("g_img_path not between", value1, value2, "gImgPath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}