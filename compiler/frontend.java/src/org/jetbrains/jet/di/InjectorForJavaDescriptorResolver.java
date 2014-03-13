/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.context.GlobalContextImpl;
import org.jetbrains.jet.storage.LockBasedStorageManager;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptorImpl;
import org.jetbrains.jet.lang.resolve.java.JavaDescriptorResolver;
import org.jetbrains.jet.lang.resolve.java.JavaClassFinderImpl;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedExternalSignatureResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedJavaResolverCache;
import org.jetbrains.jet.lang.resolve.java.resolver.TraceBasedErrorReporter;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedMethodSignatureChecker;
import org.jetbrains.jet.lang.resolve.java.resolver.PsiBasedExternalAnnotationResolver;
import org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder;
import org.jetbrains.jet.descriptors.serialization.descriptors.MemberFilter;
import org.jetbrains.jet.lang.resolve.java.lazy.LazyJavaPackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.java.lazy.GlobalJavaResolverContext;
import org.jetbrains.jet.lang.resolve.kotlin.DeserializedDescriptorResolver;
import org.jetbrains.jet.lang.resolve.kotlin.DescriptorDeserializers;
import org.jetbrains.jet.lang.resolve.kotlin.AnnotationDescriptorDeserializer;
import org.jetbrains.jet.lang.resolve.kotlin.DescriptorDeserializersStorage;
import org.jetbrains.jet.lang.resolve.kotlin.ConstantDescriptorDeserializer;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("ALL")
public class InjectorForJavaDescriptorResolver {
    
    private final Project project;
    private final BindingTrace bindingTrace;
    private final GlobalContextImpl globalContext;
    private final LockBasedStorageManager lockBasedStorageManager;
    private final ModuleDescriptorImpl module;
    private final JavaDescriptorResolver javaDescriptorResolver;
    private final JavaClassFinderImpl javaClassFinder;
    private final TraceBasedExternalSignatureResolver traceBasedExternalSignatureResolver;
    private final TraceBasedJavaResolverCache traceBasedJavaResolverCache;
    private final TraceBasedErrorReporter traceBasedErrorReporter;
    private final PsiBasedMethodSignatureChecker psiBasedMethodSignatureChecker;
    private final PsiBasedExternalAnnotationResolver psiBasedExternalAnnotationResolver;
    private final VirtualFileFinder virtualFileFinder;
    private final MemberFilter memberFilter;
    private final LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider;
    private final GlobalJavaResolverContext globalJavaResolverContext;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final DescriptorDeserializers descriptorDeserializers;
    private final AnnotationDescriptorDeserializer annotationDescriptorDeserializer;
    private final DescriptorDeserializersStorage descriptorDeserializersStorage;
    private final ConstantDescriptorDeserializer constantDescriptorDeserializer;
    
    public InjectorForJavaDescriptorResolver(
        @NotNull Project project,
        @NotNull BindingTrace bindingTrace
    ) {
        this.project = project;
        this.bindingTrace = bindingTrace;
        this.globalContext = org.jetbrains.jet.context.ContextPackage.GlobalContext();
        this.lockBasedStorageManager = globalContext.getStorageManager();
        this.module = org.jetbrains.jet.lang.resolve.java.AnalyzerFacadeForJVM.createJavaModule("<fake-jdr-module>");
        this.javaClassFinder = new JavaClassFinderImpl();
        this.virtualFileFinder = org.jetbrains.jet.lang.resolve.kotlin.VirtualFileFinder.SERVICE.getInstance(project);
        this.deserializedDescriptorResolver = new DeserializedDescriptorResolver();
        this.psiBasedExternalAnnotationResolver = new PsiBasedExternalAnnotationResolver();
        this.traceBasedExternalSignatureResolver = new TraceBasedExternalSignatureResolver();
        this.traceBasedErrorReporter = new TraceBasedErrorReporter();
        this.psiBasedMethodSignatureChecker = new PsiBasedMethodSignatureChecker();
        this.traceBasedJavaResolverCache = new TraceBasedJavaResolverCache();
        this.globalJavaResolverContext = new GlobalJavaResolverContext(lockBasedStorageManager, getJavaClassFinder(), virtualFileFinder, deserializedDescriptorResolver, psiBasedExternalAnnotationResolver, traceBasedExternalSignatureResolver, traceBasedErrorReporter, psiBasedMethodSignatureChecker, traceBasedJavaResolverCache);
        this.lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(globalJavaResolverContext, getModule());
        this.javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider, getModule());
        this.memberFilter = org.jetbrains.jet.descriptors.serialization.descriptors.MemberFilter.ALWAYS_TRUE;
        this.descriptorDeserializers = new DescriptorDeserializers();
        this.annotationDescriptorDeserializer = new AnnotationDescriptorDeserializer();
        this.descriptorDeserializersStorage = new DescriptorDeserializersStorage(lockBasedStorageManager);
        this.constantDescriptorDeserializer = new ConstantDescriptorDeserializer();

        this.javaClassFinder.setProject(project);

        traceBasedExternalSignatureResolver.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        traceBasedExternalSignatureResolver.setProject(project);
        traceBasedExternalSignatureResolver.setTrace(bindingTrace);

        traceBasedJavaResolverCache.setTrace(bindingTrace);

        traceBasedErrorReporter.setTrace(bindingTrace);

        psiBasedMethodSignatureChecker.setExternalAnnotationResolver(psiBasedExternalAnnotationResolver);
        psiBasedMethodSignatureChecker.setExternalSignatureResolver(traceBasedExternalSignatureResolver);

        deserializedDescriptorResolver.setDeserializers(descriptorDeserializers);
        deserializedDescriptorResolver.setErrorReporter(traceBasedErrorReporter);
        deserializedDescriptorResolver.setJavaDescriptorResolver(javaDescriptorResolver);
        deserializedDescriptorResolver.setJavaPackageFragmentProvider(lazyJavaPackageFragmentProvider);
        deserializedDescriptorResolver.setMemberFilter(memberFilter);
        deserializedDescriptorResolver.setStorageManager(lockBasedStorageManager);

        descriptorDeserializers.setAnnotationDescriptorDeserializer(annotationDescriptorDeserializer);
        descriptorDeserializers.setConstantDescriptorDeserializer(constantDescriptorDeserializer);

        annotationDescriptorDeserializer.setClassResolver(javaDescriptorResolver);
        annotationDescriptorDeserializer.setErrorReporter(traceBasedErrorReporter);
        annotationDescriptorDeserializer.setKotlinClassFinder(virtualFileFinder);
        annotationDescriptorDeserializer.setStorage(descriptorDeserializersStorage);

        descriptorDeserializersStorage.setClassResolver(javaDescriptorResolver);
        descriptorDeserializersStorage.setErrorReporter(traceBasedErrorReporter);

        constantDescriptorDeserializer.setClassResolver(javaDescriptorResolver);
        constantDescriptorDeserializer.setErrorReporter(traceBasedErrorReporter);
        constantDescriptorDeserializer.setKotlinClassFinder(virtualFileFinder);
        constantDescriptorDeserializer.setStorage(descriptorDeserializersStorage);

        javaClassFinder.initialize();

    }
    
    @PreDestroy
    public void destroy() {
    }
    
    public GlobalContextImpl getGlobalContext() {
        return this.globalContext;
    }
    
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }
    
    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }
    
    public JavaClassFinderImpl getJavaClassFinder() {
        return this.javaClassFinder;
    }
    
}
