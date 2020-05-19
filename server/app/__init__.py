from flask import Flask, Response, json, jsonify, request, render_template, redirect, url_for
from flask_login import LoginManager, login_user, login_required, logout_user, current_user, UserMixin

app = Flask(__name__, static_folder='../../static/dist', template_folder='../../static') #static folder
app.config['SECRET_KEY'] = "a153246s35746d57f68g9uedtrfyughi98cyas" #secret key

#home page
@app.route('/')
@app.route("/homepage")
def homepage():
	return render_template("index.html")
