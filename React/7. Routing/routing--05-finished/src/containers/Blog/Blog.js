import React, { Component } from 'react';
// import axios from 'axios';
import { Route, NavLink, Switch, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import './Blog.css';
import Posts from './Posts/Posts';
import asyncComponent from '../../hoc/asyncComponent';


import * as actionTypes from '../../store/actions';
import { Can } from '../../Can';

// import NewPost from './NewPost/NewPost';

const AsyncNewPost = asyncComponent(() => {
    return import('./NewPost/NewPost');
});

class Blog extends Component {
    state = {
        auth: true
    }

    render () {
        return (
            <div className="Blog">
                {this.props.role}
                <button onClick={this.props.onChangeAdminRole}>Change Admin Role</button>
                <button onClick={this.props.onChangeUserRole}>Change User Role</button>           
                <header>
                    <nav>
                        <ul>
                            <Can I="manage" a="Normal"><li><NavLink
                                to="/posts/"
                                exact
                                activeClassName="my-active"
                                activeStyle={{
                                    color: '#fa923f',
                                    textDecoration: 'underline'
                                }}>Posts</NavLink></li>
                            </Can>
                            <Can I="manage" a="Normal"><li><NavLink to={{
                                pathname: '/new-post',
                                hash: '#submit',
                                search: '?quick-submit=true'
                            }}>New Post</NavLink></li>
                            </Can>
                            <Can I="manage" a="Admin"><li><NavLink to={{
                                pathname: '/admin',
                            }}>Admin</NavLink></li></Can>
                        </ul>
                    </nav>
                </header>
                {/* <Route path="/" exact render={() => <h1>Home</h1>} />
                <Route path="/" render={() => <h1>Home 2</h1>} /> */}
                <Switch>
                    {this.state.auth ? 
                        <Route 
                            path="/new-post" 
                            render={props => (
                                <Can I="manage" a="Normal">
                                {() => <AsyncNewPost {...props} />}
                                </Can>
                            )}
                        /> 
                    : null}
                    <Route 
                        path="/posts"       
                        render={props => (
                            <Can I="manage" a="Normal">
                            {() => <Posts {...props} />}
                            </Can>
                        )}
                    />
                    <Route 
                        path="/admin" 
                        exact 
                        render={props => (
                            <Can I="manage" a="Admin">
                                {()=><h1>Admin page</h1>}
                            </Can>
                        )}
                    />
                    <Route path="/error" exact render={() => <h1>Not found</h1>}/>
                    <Redirect to="/error" />
                    {/* <Route path="/" component={Posts} /> */}
                </Switch>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        role: state.role
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onChangeAdminRole: () => dispatch({type: actionTypes.CHANGE_ROLE, newRole: "admin"}),
        onChangeUserRole: () => dispatch({type: actionTypes.CHANGE_ROLE, newRole: "user"})
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Blog);

