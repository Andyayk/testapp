import React, { Component } from 'react';
import { Route, Link, NavLink, Switch, Redirect } from 'react-router-dom';

import Posts from './Posts/Posts';
import FullPost from './FullPost/FullPost';
import NewPost from './NewPost/NewPost';

import classes from './Blog.module.css';
import { Button } from 'primereact/button';
import { InputText } from 'primereact/inputtext';
import DataTableFilterDemo from '../../components/DataTableFilterDemo';
import DataTableCrudDemo from '../../components/DataTableCrudDemo';
import Logo from '../../assets/logo512.png';

class Blog extends Component {
    render () {
        return (
            <div className={classes.Blog}>
                <img src={Logo} alt="Logo" />
                <header>
                    <nav>
                        <ul>
                            <li><NavLink to="/posts/" exact>Home</NavLink></li>
                            <li><NavLink to={{
                                pathname: '/new-post',
                                hash: '#submit',
                                search: '?quick-submit=true'
                            }}>New Post</NavLink></li>
                        </ul>
                    </nav>
                </header>
                <Switch>
                    <Route path="/new-post" exact component={NewPost} />
                    <Route path="/posts" component={Posts} />
                    <Route render={() => <h1>Not Found</h1>} />
                    <Redirect from="/" to="/posts" />
                </Switch>
                <Button label="Save" />
                <InputText />
                <h5>Vertical Alignment - Stretch</h5>
                <div className="p-grid p-align-stretch vertical-container">
                    <div className="p-col-3">
                        <div className={classes.Box} style={{backgroundColor: 'red'}}>4</div>
                    </div>
                    <div className="p-col-6">
                        <div className={classes.Box} style={{backgroundColor: 'blue'}}>
                            <p>sDataTableCrudDeDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogDataTableCrudDemogmogs</p>
                            <p>asd</p>
                            <p>fffd</p>
                            <p>dss</p>
                            <p>aaataTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemogtaTableCrudDeDataTableCrudDemog</p>
                        </div>
                    </div>
                    <div className="p-col-3">
                        <div className={classes.Box} style={{backgroundColor: 'green'}}>4</div>
                    </div>
                </div>
                <i className="pi pi-check p-mr-2"></i>
            </div>
        );
    }
}

export default Blog;