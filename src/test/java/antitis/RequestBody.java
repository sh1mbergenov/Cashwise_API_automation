package antitis;

    public class RequestBody {
        private String email;
        public String password;
        private String type_of_pay;
        private String bank_account_name;
        private String description;
        private int balance;

        private String category_title;
        private String category_description;
        private boolean flag;

        private String company_name;
        private String seller_name;
        private String phone_number;
        private String address;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getType_of_pay() {
            return type_of_pay;
        }

        public void setType_of_pay(String type_of_pay) {
            this.type_of_pay = type_of_pay;
        }

        public String getBank_account_name() {
            return bank_account_name;
        }

        public void setBank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getCategory_title() {
            return category_title;
        }

        public void setCategory_title(String category_title) {
            this.category_title = category_title;
        }

        public String getCategory_description() {
            return category_description;
        }

        public void setCategory_description(String category_description) {
            this.category_description = category_description;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
