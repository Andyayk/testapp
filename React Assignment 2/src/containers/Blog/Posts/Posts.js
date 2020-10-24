import React, { Component } from 'react';
import axios from 'axios';
import { Link, Route } from 'react-router-dom';

import Post from '../../../components/Post/Post';
import FullPost from '../FullPost/FullPost';

import classes from './Posts.module.css';

class Posts extends Component {
    state = {
        posts: [],
        selectedPostId: null
    }

    componentDidMount () {
        axios.get('https://jsonplaceholder.typicode.com/posts')
        .then(response => {
            const posts = response.data.splice(0, 4);
            const updatePosts = posts.map(post => {
                return {
                    ...post,
                    author: 'Max'
                }
            })
            this.setState({posts: updatePosts});
        });
    }

    postSelectedHandler = (id) => {
        this.setState({selectedPostId: id});
        //this.props.history.push('/posts/' + id);
    }

    render () {
        const posts = this.state.posts.map(post => {
            return (
                <Link to={'/posts/' + post.id} key={post.id}>
                    <Post 
                    key={post.id}
                    title={post.title}
                    author={post.author}
                    clicked={() => this.postSelectedHandler(post.id)}/>
                </Link>
            );
        });

        return (
            <div style={{display: "flex",
            justifyContent: "space-between"}}>
                <section className={classes.Posts}>
                    {posts}
                </section>
                <Route path={this.props.match.url + "/:id"} exact component={FullPost} />
            </div>
        );
    }
}

export default Posts;