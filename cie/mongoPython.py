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

def menu():
    print("\nEmployee Database Menu")
    print("1. Create Employee")
    print("2. Read Employee")
    print("3. Update Employee")
    print("4. Delete Employee")
    print("5. Exit")

if __name__ == "__main__":
    db = EmployeeDB("company_db", "employees")

    while True:
        menu()
        choice = input("Enter your choice (1-5): ")

        if choice == "1":
            name = input("Enter employee name: ")
            age = int(input("Enter employee age: "))
            department = input("Enter employee department: ")
            position = input("Enter employee position: ")

            new_employee = {
                "name": name,
                "age": age,
                "department": department,
                "position": position
            }
            db.create_employee(new_employee)

        elif choice == "2":
            name = input("Enter employee name to search: ")
            employee = db.read_employee({"name": name})
            print(f"Employee details: {employee}")

        elif choice == "3":
            name = input("Enter employee name to update: ")
            updated_field = input("Enter the field to update (age, department, position): ")
            updated_value = input(f"Enter new value for {updated_field}: ")

            db.update_employee({"name": name}, {updated_field: updated_value})

        elif choice == "4":
            name = input("Enter employee name to delete: ")
            db.delete_employee({"name": name})

        elif choice == "5":
            print("Exiting the program.")
            break

        else:
            print("Invalid choice, please try again.")
