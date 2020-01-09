package com.ormediagroup.myapplication.bean;

import java.util.List;

/**
 * Created by Lau on 2020-01-07.
 */
public class PropertyBean {

    @Override
    public String toString() {
        return "PropertyBean{" +
                "list=" + list +
                '}';
    }

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * property_id : 41
         * status : 正常
         * admin_wp_id : 6
         * agm_date : 0000-00-00
         * oc_exist : 1
         * name_zh : 第一大廈
         * name_en : First Building
         * address_zh : 大埔第一街12號12樓12室
         * address_en : 大埔第一街12號12樓12室
         * type : 單棟式大廈
         * build_year : 2001
         * floor_amount : 11
         * unit_amount : 38
         * total_size : 580
         * floor_plan_file : [{"uid":"374","name":"WhatsApp Image 2019-10-16 at 11.34.44.jpeg","status":"done","url":"http://34.92.191.50/wp-content/uploads/2019/10/WhatsApp-Image-2019-10-16-at-11.34.44-13.jpeg"}]
         * dmc_file : [{"uid":"375","name":"螢幕截圖 2019-10-16 下午3.30.36.png","status":"done","url":"http://34.92.191.50/wp-content/uploads/2019/10/螢幕截圖-2019-10-16-下午3.30.36.png"},{"uid":"376","name":"WhatsApp Image 2019-10-16 at 11.34.44.jpeg","status":"done","url":"http://34.92.191.50/wp-content/uploads/2019/10/WhatsApp-Image-2019-10-16-at-11.34.44-14.jpeg"},{"uid":"377","name":"螢幕截圖 2019-10-16 上午11.22.23.png","status":"done","url":"http://34.92.191.50/wp-content/uploads/2019/10/螢幕截圖-2019-10-16-上午11.22.23.png"},{"uid":"962","name":"compressed.tracemonkey-pldi-09.pdf","status":"done","url":"http://keylab.cc/wp-content/uploads/2020/01/compressed.tracemonkey-pldi-09.pdf"}]
         * remarks :
         */

        private String property_id;
        private String status;
        private String admin_wp_id;
        private String agm_date;
        private String oc_exist;
        private String name_zh;
        private String name_en;
        private String address_zh;
        private String address_en;
        private String type;
        private String build_year;
        private String floor_amount;
        private String unit_amount;
        private String total_size;
        private String remarks;
        private List<FloorPlanFileBean> floor_plan_file;
        private List<DmcFileBean> dmc_file;

        @Override
        public String toString() {
            return "ListBean{" +
                    "property_id='" + property_id + '\'' +
                    ", status='" + status + '\'' +
                    ", admin_wp_id='" + admin_wp_id + '\'' +
                    ", agm_date='" + agm_date + '\'' +
                    ", oc_exist='" + oc_exist + '\'' +
                    ", name_zh='" + name_zh + '\'' +
                    ", name_en='" + name_en + '\'' +
                    ", address_zh='" + address_zh + '\'' +
                    ", address_en='" + address_en + '\'' +
                    ", type='" + type + '\'' +
                    ", build_year='" + build_year + '\'' +
                    ", floor_amount='" + floor_amount + '\'' +
                    ", unit_amount='" + unit_amount + '\'' +
                    ", total_size='" + total_size + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", floor_plan_file=" + floor_plan_file +
                    ", dmc_file=" + dmc_file +
                    '}';
        }

        public String getProperty_id() {
            return property_id;
        }

        public void setProperty_id(String property_id) {
            this.property_id = property_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdmin_wp_id() {
            return admin_wp_id;
        }

        public void setAdmin_wp_id(String admin_wp_id) {
            this.admin_wp_id = admin_wp_id;
        }

        public String getAgm_date() {
            return agm_date;
        }

        public void setAgm_date(String agm_date) {
            this.agm_date = agm_date;
        }

        public String getOc_exist() {
            return oc_exist;
        }

        public void setOc_exist(String oc_exist) {
            this.oc_exist = oc_exist;
        }

        public String getName_zh() {
            return name_zh;
        }

        public void setName_zh(String name_zh) {
            this.name_zh = name_zh;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getAddress_zh() {
            return address_zh;
        }

        public void setAddress_zh(String address_zh) {
            this.address_zh = address_zh;
        }

        public String getAddress_en() {
            return address_en;
        }

        public void setAddress_en(String address_en) {
            this.address_en = address_en;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBuild_year() {
            return build_year;
        }

        public void setBuild_year(String build_year) {
            this.build_year = build_year;
        }

        public String getFloor_amount() {
            return floor_amount;
        }

        public void setFloor_amount(String floor_amount) {
            this.floor_amount = floor_amount;
        }

        public String getUnit_amount() {
            return unit_amount;
        }

        public void setUnit_amount(String unit_amount) {
            this.unit_amount = unit_amount;
        }

        public String getTotal_size() {
            return total_size;
        }

        public void setTotal_size(String total_size) {
            this.total_size = total_size;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public List<FloorPlanFileBean> getFloor_plan_file() {
            return floor_plan_file;
        }

        public void setFloor_plan_file(List<FloorPlanFileBean> floor_plan_file) {
            this.floor_plan_file = floor_plan_file;
        }

        public List<DmcFileBean> getDmc_file() {
            return dmc_file;
        }

        public void setDmc_file(List<DmcFileBean> dmc_file) {
            this.dmc_file = dmc_file;
        }

        public static class FloorPlanFileBean {
            /**
             * uid : 374
             * name : WhatsApp Image 2019-10-16 at 11.34.44.jpeg
             * status : done
             * url : http://34.92.191.50/wp-content/uploads/2019/10/WhatsApp-Image-2019-10-16-at-11.34.44-13.jpeg
             */

            private String uid;
            private String name;
            private String status;
            private String url;

            @Override
            public String toString() {
                return "FloorPlanFileBean{" +
                        "uid='" + uid + '\'' +
                        ", name='" + name + '\'' +
                        ", status='" + status + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class DmcFileBean {
            /**
             * uid : 375
             * name : 螢幕截圖 2019-10-16 下午3.30.36.png
             * status : done
             * url : http://34.92.191.50/wp-content/uploads/2019/10/螢幕截圖-2019-10-16-下午3.30.36.png
             */

            private String uid;
            private String name;
            private String status;
            private String url;

            @Override
            public String toString() {
                return "DmcFileBean{" +
                        "uid='" + uid + '\'' +
                        ", name='" + name + '\'' +
                        ", status='" + status + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
