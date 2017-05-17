module.exports = function(grunt) {
    // Init config for all tasks.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        concat: {
            dist: {
                src: [
                    '../assets/js/libs/modernizr.custom.js',
                    '../assets/js/libs/jquery.min.js',
                    '../assets/js/libs/jquery-ui.min.js',
                    '../assets/js/libs/bootstrap.js',
                    '../assets/js/libs/*.js',
                    '../assets/js/*.js',
                ],
                dest: '../build/js/all.js',
            }
        },
        uglify: {
            build: {
                src: '../build/js/all.js',
                dest: '../build/js/min.js'
            }
        },
        sass: {
            dist: {
                options: {
                    style: 'expanded' // OR "compressed" For min style.css file
                },
                files: {
                    '../assets/css/style.css': '../assets/sass/style.scss'
                }
            }
        },
        cssmin: {
            options: {
                keepSpecialComments: 0 // For removing all CSS comments
            },
            target: {
                files: {
                    '../build/css/min.css': '../assets/css/**/*.css'
                }
            }
        },
        imagemin: {
            dynamic: {
                files: [{
                    expand: true,
                    cwd: '../assets/img',
                    src: ['**/*.{png,jpg,gif,svg}'],
                    dest: '../build/img'
                }]
            }
        },
        copy: {
            main: {
                expand: true,
                cwd: '../assets/fonts/',
                src: ['**/*'],
                dest: '../build/fonts/',
            },
        },
        watch: {
            options: {
                livereload: true,
            },
            scripts: {
                files: ['../assets/js/*.js'],
                tasks: ['concat', 'uglify'],
                options: {
                    spawn: false,
                },
            },
            css: {
                files: ['../assets/sass/*.scss'],
                tasks: ['sass', 'cssmin'],
                options: {
                    spawn: false,
                },
            },
            images: {
                files: ['../assets/img/**/*.{png,jpg,gif,svg}'],
                tasks: ['imagemin'],
                options: {
                    spawn: false,
                }
            }
        }

    });

    // Tasks
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');

    // Register Task
    grunt.registerTask('default', ['concat', 'uglify', 'sass', 'cssmin', 'imagemin', 'copy', 'watch']);

};