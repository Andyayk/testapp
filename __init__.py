from flask import Flask, Response, json, jsonify, request, render_template, redirect, url_for
from flask_login import LoginManager, login_user, login_required, logout_user, current_user, UserMixin

app = Flask(__name__, static_folder='static', template_folder='static') #static folder
app.config['SECRET_KEY'] = "a153246s35746d57f68g9uedtrfyughi98cyas" #secret key

login_manager = LoginManager() #flask login
login_manager.init_app(app) #initialise app

#home page
@app.route("/homepage")
def homepage():
	return render_template("index.html")
