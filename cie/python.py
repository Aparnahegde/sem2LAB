from pymongo import MongoClient

class EmployeeDB:
    def __init__(self, db_name, collection_name):
        self.client = MongoClient('mongodb://localhost:27017/')
        self.db = self.client[db_name]
        self.collection = self.db[collection_name]

    def create_employee(self, employee_data):
        result = self.collection.insert_one(employee_data)
        print(f"Employee inserted with id: {result.inserted_id}")

    def read_employee(self, query):
        employee = self.collection.find_one(query)
        return employee if employee else "No matching employee found."

    def update_employee(self, query, updated_data):
        result = self.collection.update_one(query, {"$set": updated_data})
        print("Employee updated successfully." if result.matched_count > 0 else "No employee found with the given query.")

    def delete_employee(self, query):
        result = self.collection.delete_one(query)
        print("Employee deleted successfully." if result.deleted_count > 0 else "No employee found with the given query.")

if __name__ == "__main__":
    db = EmployeeDB("company_db", "employees")

    new_employee = {
        "name": "John Doe",
        "age": 30,
        "department": "Engineering",
        "position": "Software Engineer"
    }
    db.create_employee(new_employee)

    print(db.read_employee({"name": "John Doe"}))

    db.update_employee({"name": "John Doe"}, {"age": 31})

    db.delete_employee({"name": "John Doe"})
