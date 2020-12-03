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
import { Calendar } from 'primereact/calendar';

import './Calendar.css';

class Blog extends Component {
    state = {
        date: ''
    }

    render () {
        return (
            <div className={classes.Blog}>
                <table>
                <thead>
                    <tr>
                    <th>Name</th>
                    <th>ID</th>
                    <th>Favorite Color</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>Jim</td>
                    <td>00001</td>
                    <td>Blue</td>
                    </tr>
                    <tr>
                    <td>Sue</td>
                    <td>00002</td>
                    <td>Red</td>
                    </tr>
                    <tr>
                    <td>Barb</td>
                    <td>00003</td>
                    <td>Green</td>
                    </tr>
                </tbody>
                </table>

                <div class="ui-grid">
                    <div class="ui-grid-col-4">Col1</div>
                    <div class="ui-grid-col-4">Col2
                    </div>
                    <div class="ui-grid-col-4">Col2</div>
                </div>

                <div className="p-d-flex">Flex Container</div>
                <div className="p-d-inline-flex">Inline Flex Container</div>

                <div className="p-d-flex p-flex-column">
                    <div className="p-mt-2">Item 1</div>
                    <div className="p-mb-2">Item 2</div>
                    <div>Item 3</div>
                </div>

                <div className="p-d-flex p-flex-column p-flex-md-row">
                    <div className="p-mb-2 p-mr-2">Item 1</div>
                    <div className="p-mb-2 p-mr-2">Item 2
                    <Calendar 
                        value={this.state.date} 
                        appendTo={document.body}
                        onChange={(e) => this.setState({date: e.value})}>
                    </Calendar>
                    </div>
                    <div className="p-mb-2 p-mr-2">Item 3</div>
                </div>

                <div className="p-d-flex">
                    <div className="p-mr-2 p-order-3">Item 1</div>
                    <div className="p-mr-2 p-order-1">Item 2</div>
                    <div className="p-mr-2 p-order-2">Item 3</div>
                </div>

                <div className="p-d-flex">
                    <div className="p-mr-2 p-order-3 p-order-md-2">Item 1</div>
                    <div className="p-mr-2 p-order-1 p-order-md-3">Item 2</div>
                    <div className="p-mr-2 p-order-2 p-order-md-1">Item 3</div>
                </div>

                <div className="p-grid p-jc-center">
                    <div className="p-d-flex p-jc-around p-col-3 p-m-2" style={{border: "1px solid red"}}>
                        <div>Item 1</div>
                        <div>Item 2</div>
                    </div>

                    <div className="p-d-flex p-col-3 p-m-2" style={{border: "1px solid red"}}>
                        <div>Item 1</div>
                        <div>Item 2</div>
                    </div>

                    <div className="p-d-flex p-col-3 p-m-2" style={{border: "1px solid red"}}>
                        <div>Item 1</div>
                        <div>Item 2</div>
                    </div>
                </div>

                <div className="p-d-flex p-ai-center">
                    <div className="p-mr-2" style={{height: '100px', border: "1px solid red"}}>Item 1</div>
                    <div style={{height: '50px', border: "1px solid red"}}>Item 2</div>
                </div>
 
                <div className="p-d-flex p-p-5 card">
                    <Button type="Button" icon="pi pi-check" className="p-mr-2" />
                    <div>hello</div>
                    <Button type="Button" icon="pi pi-search" className="p-ml-auto p-button-help"/>
                </div>

                <div style={{width: '10rem'}}>Long text wraps and does not overlow.</div>
                <div className="p-text-nowrap" style={{width: '10rem'}}>Long text does not wrap and overflows the parent.</div>
                <div className="p-text-nowrap p-text-truncate" style={{width: '10rem'}}>Long text does not wrap and overflows the parent.</div>

                <img src={Logo} alt="Logo" style={{height: "30px", width: "30px"}}/>
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
                <Button label="Save" onClick="" />
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