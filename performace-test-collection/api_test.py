from locust import FastHttpUser,task,between
from random import randint
from faker import Faker
fake = Faker()


class WebsiteUser(FastHttpUser):
    wait_time = between(1, 5)


    def on_start(self):
        self.client.headers = {'Content-Type': 'application/json'}

    #@task
    def getAllUsers(self):
        self.client.get(url="getUsers")

    @task
    def getUserById(self):
        self.client.get(url="getUserBId/1234")

    @task
    def saveUser(self):
        self.client.post("saveUser",json= {
        "name": fake.name(),
        "address": fake.address(),
        "id": randint(100,3000000),
        "age": randint(2,100)
        }) 