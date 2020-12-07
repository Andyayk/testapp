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
                <button onClick={this.props.onChangeRole}>Change Role</button>
                <Can I="read" a="Post">
                    <button>read Post</button>
                </Can>   
                <Can I="update" a="Post">
                    <button>update update</button>
                </Can>   
                <Can I="read" a="Comment">
                    <button>read Comment</button>
                </Can>   
                <Can I="update" a="Comment">
                    <button>update Comment</button>
                </Can> 
                <Can I="delete" a="Comment">
                    <button>delete Comment</button>
                </Can>                
                <header>
                    <nav>
                        <ul>
                            <li><NavLink
                                to="/posts/"
                                exact
                                activeClassName="my-active"
                                activeStyle={{
                                    color: '#fa923f',
                                    textDecoration: 'underline'
                                }}>Posts</NavLink></li>
                            <li><NavLink to={{
                                pathname: '/new-post',
                                hash: '#submit',
                                search: '?quick-submit=true'
                            }}>New Post</NavLink></li>
                            <li><NavLink to={{
                                pathname: '/admin',
                            }}>Admin</NavLink></li>
                        </ul>
                    </nav>
                </header>
                {/* <Route path="/" exact render={() => <h1>Home</h1>} />
                <Route path="/" render={() => <h1>Home 2</h1>} /> */}
                <Switch>
                    {this.state.auth ? <Route path="/new-post" component={AsyncNewPost} /> : null}
                    <Route path="/posts" component={Posts} />
                    <Route path="/admin" render={() => (<h1>Admin page</h1>)}/>
                    <Route render={() => <h1>Not found</h1>}/>
                    {/* <Redirect from="/" to="/posts" /> */}
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
        onChangeRole: () => dispatch({type: actionTypes.CHANGE_ROLE, newRole: "admin"})
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Blog);

