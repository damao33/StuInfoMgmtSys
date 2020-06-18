package cn.sims.model;

import java.util.ArrayList;
import java.util.List;

public class ClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andClnoIsNull() {
            addCriterion("Clno is null");
            return (Criteria) this;
        }

        public Criteria andClnoIsNotNull() {
            addCriterion("Clno is not null");
            return (Criteria) this;
        }

        public Criteria andClnoEqualTo(String value) {
            addCriterion("Clno =", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoNotEqualTo(String value) {
            addCriterion("Clno <>", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoGreaterThan(String value) {
            addCriterion("Clno >", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoGreaterThanOrEqualTo(String value) {
            addCriterion("Clno >=", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoLessThan(String value) {
            addCriterion("Clno <", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoLessThanOrEqualTo(String value) {
            addCriterion("Clno <=", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoLike(String value) {
            addCriterion("Clno like", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoNotLike(String value) {
            addCriterion("Clno not like", value, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoIn(List<String> values) {
            addCriterion("Clno in", values, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoNotIn(List<String> values) {
            addCriterion("Clno not in", values, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoBetween(String value1, String value2) {
            addCriterion("Clno between", value1, value2, "clno");
            return (Criteria) this;
        }

        public Criteria andClnoNotBetween(String value1, String value2) {
            addCriterion("Clno not between", value1, value2, "clno");
            return (Criteria) this;
        }

        public Criteria andClnameIsNull() {
            addCriterion("Clname is null");
            return (Criteria) this;
        }

        public Criteria andClnameIsNotNull() {
            addCriterion("Clname is not null");
            return (Criteria) this;
        }

        public Criteria andClnameEqualTo(String value) {
            addCriterion("Clname =", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotEqualTo(String value) {
            addCriterion("Clname <>", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThan(String value) {
            addCriterion("Clname >", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThanOrEqualTo(String value) {
            addCriterion("Clname >=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThan(String value) {
            addCriterion("Clname <", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThanOrEqualTo(String value) {
            addCriterion("Clname <=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLike(String value) {
            addCriterion("Clname like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotLike(String value) {
            addCriterion("Clname not like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameIn(List<String> values) {
            addCriterion("Clname in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotIn(List<String> values) {
            addCriterion("Clname not in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameBetween(String value1, String value2) {
            addCriterion("Clname between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotBetween(String value1, String value2) {
            addCriterion("Clname not between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andHtnameIsNull() {
            addCriterion("Htname is null");
            return (Criteria) this;
        }

        public Criteria andHtnameIsNotNull() {
            addCriterion("Htname is not null");
            return (Criteria) this;
        }

        public Criteria andHtnameEqualTo(String value) {
            addCriterion("Htname =", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameNotEqualTo(String value) {
            addCriterion("Htname <>", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameGreaterThan(String value) {
            addCriterion("Htname >", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameGreaterThanOrEqualTo(String value) {
            addCriterion("Htname >=", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameLessThan(String value) {
            addCriterion("Htname <", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameLessThanOrEqualTo(String value) {
            addCriterion("Htname <=", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameLike(String value) {
            addCriterion("Htname like", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameNotLike(String value) {
            addCriterion("Htname not like", value, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameIn(List<String> values) {
            addCriterion("Htname in", values, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameNotIn(List<String> values) {
            addCriterion("Htname not in", values, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameBetween(String value1, String value2) {
            addCriterion("Htname between", value1, value2, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnameNotBetween(String value1, String value2) {
            addCriterion("Htname not between", value1, value2, "htname");
            return (Criteria) this;
        }

        public Criteria andHtnoIsNull() {
            addCriterion("Htno is null");
            return (Criteria) this;
        }

        public Criteria andHtnoIsNotNull() {
            addCriterion("Htno is not null");
            return (Criteria) this;
        }

        public Criteria andHtnoEqualTo(String value) {
            addCriterion("Htno =", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoNotEqualTo(String value) {
            addCriterion("Htno <>", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoGreaterThan(String value) {
            addCriterion("Htno >", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoGreaterThanOrEqualTo(String value) {
            addCriterion("Htno >=", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoLessThan(String value) {
            addCriterion("Htno <", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoLessThanOrEqualTo(String value) {
            addCriterion("Htno <=", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoLike(String value) {
            addCriterion("Htno like", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoNotLike(String value) {
            addCriterion("Htno not like", value, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoIn(List<String> values) {
            addCriterion("Htno in", values, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoNotIn(List<String> values) {
            addCriterion("Htno not in", values, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoBetween(String value1, String value2) {
            addCriterion("Htno between", value1, value2, "htno");
            return (Criteria) this;
        }

        public Criteria andHtnoNotBetween(String value1, String value2) {
            addCriterion("Htno not between", value1, value2, "htno");
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