package cn.sims.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTnoIsNull() {
            addCriterion("Tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("Tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(String value) {
            addCriterion("Tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(String value) {
            addCriterion("Tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(String value) {
            addCriterion("Tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(String value) {
            addCriterion("Tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(String value) {
            addCriterion("Tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(String value) {
            addCriterion("Tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLike(String value) {
            addCriterion("Tno like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotLike(String value) {
            addCriterion("Tno not like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<String> values) {
            addCriterion("Tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<String> values) {
            addCriterion("Tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(String value1, String value2) {
            addCriterion("Tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(String value1, String value2) {
            addCriterion("Tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("Tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("Tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("Tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("Tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("Tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("Tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("Tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("Tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("Tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("Tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("Tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("Tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("Tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("Tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTsexIsNull() {
            addCriterion("Tsex is null");
            return (Criteria) this;
        }

        public Criteria andTsexIsNotNull() {
            addCriterion("Tsex is not null");
            return (Criteria) this;
        }

        public Criteria andTsexEqualTo(String value) {
            addCriterion("Tsex =", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotEqualTo(String value) {
            addCriterion("Tsex <>", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThan(String value) {
            addCriterion("Tsex >", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThanOrEqualTo(String value) {
            addCriterion("Tsex >=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThan(String value) {
            addCriterion("Tsex <", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThanOrEqualTo(String value) {
            addCriterion("Tsex <=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLike(String value) {
            addCriterion("Tsex like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotLike(String value) {
            addCriterion("Tsex not like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexIn(List<String> values) {
            addCriterion("Tsex in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotIn(List<String> values) {
            addCriterion("Tsex not in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexBetween(String value1, String value2) {
            addCriterion("Tsex between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotBetween(String value1, String value2) {
            addCriterion("Tsex not between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTbirthdayIsNull() {
            addCriterion("Tbirthday is null");
            return (Criteria) this;
        }

        public Criteria andTbirthdayIsNotNull() {
            addCriterion("Tbirthday is not null");
            return (Criteria) this;
        }

        public Criteria andTbirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("Tbirthday =", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("Tbirthday <>", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("Tbirthday >", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Tbirthday >=", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayLessThan(Date value) {
            addCriterionForJDBCDate("Tbirthday <", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Tbirthday <=", value, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("Tbirthday in", values, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("Tbirthday not in", values, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Tbirthday between", value1, value2, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTbirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Tbirthday not between", value1, value2, "tbirthday");
            return (Criteria) this;
        }

        public Criteria andTprofessorIsNull() {
            addCriterion("Tprofessor is null");
            return (Criteria) this;
        }

        public Criteria andTprofessorIsNotNull() {
            addCriterion("Tprofessor is not null");
            return (Criteria) this;
        }

        public Criteria andTprofessorEqualTo(String value) {
            addCriterion("Tprofessor =", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorNotEqualTo(String value) {
            addCriterion("Tprofessor <>", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorGreaterThan(String value) {
            addCriterion("Tprofessor >", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorGreaterThanOrEqualTo(String value) {
            addCriterion("Tprofessor >=", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorLessThan(String value) {
            addCriterion("Tprofessor <", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorLessThanOrEqualTo(String value) {
            addCriterion("Tprofessor <=", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorLike(String value) {
            addCriterion("Tprofessor like", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorNotLike(String value) {
            addCriterion("Tprofessor not like", value, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorIn(List<String> values) {
            addCriterion("Tprofessor in", values, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorNotIn(List<String> values) {
            addCriterion("Tprofessor not in", values, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorBetween(String value1, String value2) {
            addCriterion("Tprofessor between", value1, value2, "tprofessor");
            return (Criteria) this;
        }

        public Criteria andTprofessorNotBetween(String value1, String value2) {
            addCriterion("Tprofessor not between", value1, value2, "tprofessor");
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